#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/init.h>
#include <linux/interrupt.h>
#include <asm/io.h>

#include <linux/fs.h>
#include <linux/uaccess.h>
#include <linux/types.h>
#include <linux/ioport.h>
#include <linux/cdev.h>
#include <linux/device.h>

MODULE_LICENSE("GPL");
MODULE_AUTHOR("SangKyun Yun");
MODULE_DESCRIPTION("Seven Segment LEDs");

void init_add_timer(void);
void remove_timer(void);
void hex_timer_function(unsigned long ptr);

#define base_lwFPGA 0xFF200000
#define len_lwFPGA  0x200000

#define addr_LED  0
#define addr_HEX0 0x20
#define addr_HEX1 0x30
#define addr_SW   0x40
#define addr_KEY  0x50

static void *mem_base;
static void *hex0_addr;
static void *hex1_addr;
static unsigned int data = -1;

static unsigned int mode = 0;
#define NOFILL 4
#define BLINK  8

unsigned int hex0, hex1;

int hex_conversion[16] = {
        0x3F,0x06,0x5B,0x4F,0x66,0x6D,0x7D,0x07,
        0x7F,0x67,0x77,0x7C,0x39,0x5E,0x79,0x71
};

static ssize_t hex_write (struct file *file, const char __user *buf, size_t count, loff_t *f_pos) {
        unsigned int hex_data = 0;
        unsigned int nofill = 0;

        get_user(hex_data, (unsigned int *)buf);
        hex_data = hex_data & 0xFFFFFF;
        data = hex_data;

        if (mode & NOFILL) nofill = 1;

        hex1 = 0;
        hex0 = hex_conversion[hex_data & 0xf];

        do{
                hex_data >>= 4;
                if (nofill && hex_data == 0) break;
                hex0 |= hex_conversion[hex_data &0xf]<<8;

                hex_data >>= 4;
                if (nofill && hex_data == 0) break;
                hex0 |= hex_conversion[hex_data & 0xf]<<16;

                hex_data >>= 4;
                if (nofill && hex_data == 0) break;
                hex0 |= hex_conversion[hex_data & 0xf]<<24;

                hex_data >>= 4;
                if(nofill && hex_data == 0) break;
                hex1 = hex_conversion[hex_data & 0xf];

                hex_data >>= 4;
                if (nofill && hex_data == 0) break;
                hex1 |= hex_conversion[hex_data &0xf]<<8;
        } while(0);

        iowrite32(hex0, hex0_addr);
        iowrite32(hex1, hex1_addr);

        return 4;
}

static ssize_t hex_read (struct file *file, char __user *buf ,size_t count, loff_t *f_pos) {
        put_user(data, (unsigned int *) buf);
        return 4;
}

static int hex_open(struct inode *minode, struct file *mfile) {
        return 0;
}

static int hex_release(struct inode *minode, struct file *mfile) {
        return 0;
}

static long hex_ioctl(struct file *file, unsigned int cmd, unsigned long arg) {
        unsigned int newcmd;

        newcmd = cmd;
        if ( (mode & BLINK) && !(newcmd & BLINK))
                remove_timer();
        else if ( !(mode & BLINK) && (newcmd & BLINK))
                init_add_timer();
        mode = newcmd;

        return 0;
}

static struct file_operations hex_fops = {
        .read = hex_read,
        .write = hex_write,
        .open = hex_open,
        .release = hex_release,
        .unlocked_ioctl  = hex_ioctl,
};

static struct cdev hex_cdev;
static struct class *cl;
static dev_t  dev_no;

#define DEVICE_NAME "hex"

static int __init hex_init(void) {
        if (alloc_chrdev_region(&dev_no, 0, 1, DEVICE_NAME) < 0) {
            printk(KERN_ERR "alloc_chrdev_region error\n");
        return -1;
        }
        cdev_init(&hex_cdev,&hex_fops);

        if(cdev_add(&hex_cdev, dev_no, 1) < 0) {
        printk(KERN_ERR "cdev_add() error \n");
        goto unreg_chrdev;
        }

        cl = class_create (THIS_MODULE, DEVICE_NAME);
        if(cl==NULL){
        printk(KERN_ALERT "class_create() error\n");
        goto unreg_chrdev;
        }

        if(device_create(cl, NULL, dev_no, NULL, DEVICE_NAME) == NULL) {
        printk(KERN_ALERT "device_create error\n");
        goto unreg_class;
        }

        mem_base = ioremap_nocache(base_lwFPGA, len_lwFPGA);
        if(mem_base == NULL) {
        printk(KERN_ERR "ioremap_nocache() error \n");
        goto un_device;
        }

        printk("Device: %s Major %d %x\n", DEVICE_NAME, MAJOR(dev_no), dev_no);
        hex0_addr = mem_base + addr_HEX0;
        hex1_addr = mem_base + addr_HEX1;

        return 0;

// error
un_device:
        device_destroy(cl, dev_no);
unreg_class:
        class_destroy(cl);
unreg_chrdev:
        unregister_chrdev_region(dev_no, 1);
        return -1;
}

static void __exit hex_exit (void) {
        iowrite32(0, hex0_addr);
        iowrite32(0, hex1_addr);
        if(mode & BLINK)
                remove_timer();

        iounmap(mem_base);
        device_destroy(cl, dev_no);
        class_destroy(cl);
        unregister_chrdev_region(dev_no, 1);
        printk(" %s unregistered.\n", DEVICE_NAME);
}

module_init(hex_init);
module_exit(hex_exit);

static int turnoff = 0;
static struct timer_list hex_timer;

void init_add_timer (void) {
        init_timer(&hex_timer);

        hex_timer.function = hex_timer_function;
        hex_timer.expires = jiffies + HZ; //after 1 sec
        hex_timer.data = 0;

        add_timer(&hex_timer);
}

void remove_timer (void) {
        del_timer(&hex_timer);
}

void hex_timer_function(unsigned long ptr) {
        if( !(mode & BLINK) ) return;
        turnoff = !turnoff;
        if(turnoff) {
                iowrite32(0, hex0_addr);
                iowrite32(0, hex1_addr);
        } else {
                iowrite32(hex0, hex0_addr);
                iowrite32(hex1, hex1_addr);
        }

        init_add_timer();
}
