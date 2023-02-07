// - include ioctl() : NOFILL

#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/init.h>
#include <asm/io.h>

#include <linux/fs.h>
#include <linux/uaccess.h>
#include <linux/types.h>
#include <linux/ioport.h>

MODULE_LICENSE("GPL");
MODULE_AUTHOR("SangKyun Yun"):
MODULE_DESCRIPTION("Seven Segment LEDs");

#define base_1wFPGA   0xFF200000
#define len_1wFPGA    0x200000

#define addr_LED       0
#define addr_HEX0     0x20
#define addr_HEX1     0x30
#define addr_SW       0x40
#define addr_KEY       0x50

#define HEX_DEVMAJOR  240
#define HEX_DEVNAME   "hex"

static void *mem_base;
static void *hex0_addr;       //HEX3-HEX0
static void *hex1_addr;       //HEX5-HEX4
static unsigned int data = -1;

static unsigned int mode = 0;
#define NOFILL  4    //bit 2
#define BLINK   8    //bit 3

unsigned int hex0, hex1;     //HEX LED output data

int hex_conversion[16] = {
		0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 
		0x7F, 0x67, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71
};

static ssize_t hex_write (struct file *file, const char __user *buf, size_t count,
	loft_t *f_pos){
		unsigned int hex_data = 0;
		unsigned int nofill = 0;
		
		get_user(hex_data, (unsigned int *)buf);  //copy_from_user(&hex_data, buf, count);
		hex_data = hex_data & 0xFFFFFF;
		data = hex_data;
		
		if (mode & NOFILL) nofill = 1;
		
		hex1 = 0;
		hex0 = hex_conversion[hex_data & 0xF];
		
		do {
				hex_data >>= 4;
				if (nofill && hex_data==0) break;
				hex0 |= hex_conversion[hex_data & 0xF]<<8;
					
				hex_data >>= 4;
				if (nofill && hex_data==0) break;
				hex0 |= hex_conversion[hex_data & 0xF]<<16;
										
				hex_data >>= 4;
				if (nofill && hex_data==0) break;
				hex0 |= hex_conversion[hex_data & 0xF]<<24;
				
				hex_data >>= 4;
				if (nofill && hex_data==0) break;
				hex1 |= hex_conversion[hex_data & 0xF];
				
				hex_data >>= 4;
				if (nofill && hex_data==0) break;
				hex1 |= hex_conversion[hex_data & 0xF]<<8;
            } while(0);	
}
				