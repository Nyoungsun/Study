#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/init.h>
#include <linux/interrupt.h>
#include <linux/delay.h>
#include <asm/io.h>

#include <linux/fs.h>
#include <linux/uaccess.h>
#include <linux/types.h>
#include <linux/ioport.h>
#include <linux/cdev.h>
#include <linux/device.h>

MODULE_LICENSE("GPL");
MODULE_AUTHOR("SangKyun Yun");
MODULE_DESCRIPTION("Seven Segment dispaly and LED flashing");

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
#define	INTMASK   0x8
#define	EDGE      0xC

#define	IRQ_KEYS  73

static void *mem_base;
static void *hex0_addr;
static void *hex1_addr;

void *lwbridgebase;
void *ledr_addr, *key_addr;

int press;
int i, j, k, l;

static unsigned int data = -1;
static unsigned int mode = 0;

#define NOFILL 4
#define BLINK  8

unsigned int hex0, hex1;

int hex_conversion[16] = {
        0x3F,0x06,0x5B,0x4F,0x66,0x6D,0x7D,0x07,
        0x7F,0x67,0x77,0x7C,0x39,0x5E,0x79,0x71,
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
        else if ( !(mode&BLINK) && (newcmd& BLINK))
                init_add_timer();
        mode= newcmd;

        return 0;
}

static struct file_operations hex_fops = {
        .read = hex_read,
        .write = hex_write,
        .open = hex_open,
        .release = hex_release,
        .unlocked_ioctl  = hex_ioctl,
};

irq_handler_t irq_handler(int irq, void	*dev_id, struct	pt_regs	*regs)
{	
    press = ioread32(key_addr + EDGE);
    iowrite32(0xf, key_addr + EDGE);


        int led1[] = {0x1,0x3,0x7,0xf,0x1f,0x3f,0x7f,0xff,0x1ff,
                      0x3ff,0x1ff,0x07f,0x03f,0x01f,0x00f,0x007,
                      0x003,0x001,0x0};
        if(press==0x8) {
            for (i=0; i<19; i++) {
            iowrite32(led1[i], ledr_addr);
            mdelay(50);
            } 
        }

        int led2[] = {0x201,0x303,0x387,0x3cf,0xfff,0x1fe,0x0fc,
                      0x078,0x030,0x0};
        if (press==0x4) {
            for (j=0; j<10; j++) {
            iowrite32(led2[j], ledr_addr);
            mdelay(75);
            }  
        } 

        int led3[] = {0x1,0x3,0x7,0xf,0x1f,0x3f,0x7f,0xff,0x1ff,
                      0x3ff,0x3fe,0x3fc,0x3f8,0x3f0,0x3e0,0x3c0,
                      0x380,0x300,0x200,0x0};
        if (press==0x2) {
            for (k=0; k<20; k++) {
            iowrite32(led3[k], ledr_addr);
            mdelay(50);
            }  
        }

        int led4[] = {0x1,0x2,0x4,0x8,0x10,0x20,0x40,0x80,
                      0x100,0x200,0x100,0x80,0x40,0x20,0x10,
                      0x8,0x4,0x2,0x1,0x0};  
        if (press==0x1) {              
            for (l=0; l<20; l++) {
            iowrite32(led4[l], ledr_addr);
            mdelay(50);
            }
        }
    return (irq_handler_t) IRQ_HANDLED;
}

static struct cdev hex_cdev;
static struct class *cl;
static dev_t dev_no;

#define DEVICE_NAME "hex"

static int __init init(void) {
        if (alloc_chrdev_region(&dev_no, 0, 1, DEVICE_NAME) < 0) {
            printk(KERN_ERR "alloc_chrdev_region error\n");
        return -1;
        }
        cdev_init(&hex_cdev,&hex_fops);

        if(cdev_add(&hex_cdev, dev_no, 1) < 0) {
        printk(KERN_ERR "cdev_add() error \n");
        goto unreg_chrdev;
        }

        cl =class_create (THIS_MODULE, DEVICE_NAME);
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

        lwbridgebase = ioremap_nocache(base_lwFPGA, len_lwFPGA);
	    ledr_addr = lwbridgebase + addr_LED;
	    key_addr = lwbridgebase + addr_KEY;

        mdelay(400);
        iowrite32(0x3ff, ledr_addr);
        mdelay(400);
        iowrite32(0x0, ledr_addr);
        mdelay(400);
        iowrite32(0x3ff, ledr_addr);
        mdelay(400);
        iowrite32(0x0, ledr_addr);

        iowrite32(0xf, key_addr	+ INTMASK);
        iowrite32(0xf, key_addr + EDGE);

        return request_irq(IRQ_KEYS, (irq_handler_t)irq_handler,
				IRQF_SHARED, "pushbutton_irq_handler",
                (void *)(irq_handler));

// error
un_device:
        device_destroy(cl,dev_no);
unreg_class:
        class_destroy(cl);
unreg_chrdev:
        unregister_chrdev_region(dev_no,1);
        return -1;
}

static void __exit exit (void) {
        iowrite32(0, hex0_addr);
        iowrite32(0, hex1_addr);

        iowrite32(0x0, ledr_addr);
        free_irq(IRQ_KEYS, (void*)irq_handler);
        
        if( mode & BLINK)
                remove_timer();

        iounmap(mem_base);
        device_destroy(cl,dev_no);
        class_destroy(cl);
        unregister_chrdev_region(dev_no, 1);
        printk(" %s unregistered.\n", DEVICE_NAME);
}

module_init(init);
module_exit(exit);

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
        if(!(mode & BLINK)) return;
        turnoff = !turnoff;
        if(turnoff) {
                iowrite32(0,hex0_addr);
                iowrite32(0,hex1_addr);
        } else {
                iowrite32(hex0, hex0_addr);
                iowrite32(hex1, hex1_addr);
        }

        init_add_timer();
}
