#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/init.h>
#include <linux/interrupt.h>
#include <asm/io.h>

#include <linux/fs.h>
#include <linux/uaccess.h>
#include <linux/types.h>
#include <linux/ioport.h>

#include <linux/sched.h>

#define base_lwFPGA 0xFF200000
#define len_lwFPGA 0x200000

#define addr_LED  0
#define addr_HEX0 0x20
#define addr_HEX1 0x30
#define addr_SW   0x40
#define addr_KEY  0x50

#define offset_INTMASK 0x08
#define offset_EDGE    0x0C

#define KEY_DEVMAJOR 242
#define KEY_DEVNAME  "keys"

MODULE_LICENSE("GPL");
MODULE_AUTHOR("SangKyun Yun");
MODULE_DESCRIPTION("Pushbutton Device Driver");

static void *mem_base;
static void *key_addr;

static int key_open(struct inode *minode, struct file *mfile) {
        return 0;
}

static int key_release(struct inode *minode, struct file *mfile) {
        return 0;
}

static ssize_t key_write(struct file *file, const char __user *buf, size_t count, loff_t *f_pos) {
        return 0;
}

static DECLARE_WAIT_QUEUE_HEAD(key_queue);
static int flag = 0;
unsigned int key_data;

static ssize_t key_read(struct file *file, const char __user *buf, size_t count, loff_t *f_pos) {
    wait_event_interruptible(key_queue, flag != 0);
    flag = 0;
    put_user(key_data, buf);
    return 4;
}

irq_handler_t irq_handler(int irq, void *dev_id, struct pt_regs *regs) {
    key_data = ioread32(key_addr + offset_EDGE);
    iowrite32(0xf, key_addr + offset_EDGE);

    flag = 1;
    wake_up_interruptible(&key_queue);

    return (irq_handler_t) IRQ_HANDLED;
}

static struct file_operations key_fops = {
        .read = key_read,
        .write = key_write,
        .open = key_open,
        .release = key_release,
};

static int __init keys_init(void) {
    int res;

    res = register_chrdev(KEY_DEVMAJOR, KEY_DEVNAME, &key_fops);
    if(res < 0) {
        printk(KERN_ERR " push buttons : failed to register device.\n");
        return res;
    }

    mem_base = ioremap_nocache(base_lwFPGA, len_lwFPGA);
    if( !mem_base) {
        printk("Error mapping memory\n");
        release_mem_region(base_lwFPGA, len_lwFPGA);
        return -EBUSY;
    }

    key_addr = mem_base + addr_KEY;
    iowrite32(0xf, key_addr + offset_EDGE);
    iowrite32(0xf, key_addr + offset_INTMASK);

    res = request_irq(73, (irq_handler_t)irq_handler, IRQF_SHARED, "key_irq_hanlder", (void *)(irq_handler));
    if (res) {
        printk("failed to register key interrupt handler\n");
        return res;
    }
    printk("Device %s MAJOR: %d\n", KEY_DEVNAME, KEY_DEVMAJOR);

    return 0; 
}

static void __exit keys_exit(void) {
    free_irq(73, (void*) irq_handler);
    iounmap(mem_base);
    unregister_chrdev(KEY_DEVMAJOR, KEY_DEVNAME);
    printk(" %s unregistered.\n", KEY_DEVNAME);
}

module_init(keys_init);
module_exit(keys_exit);