#include	<linux/kernel.h>
#include	<linux/module.h>
#include	<linux/init.h>
#include	<linux/interrupt.h>
#include	<asm/io.h>
#include    <linux/delay.h>

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Altera University Program, modified by skyun");
MODULE_DESCRIPTION("DE1SoC Pushbutton Interrupt	Handler");

#define	LW_BRIDGE_BASE	 0xFF200000
#define	LW_BRIDGE_SPAN   0x00200000
#define	LEDR_BASE		 0x00
#define	KEY_BASE 		 0x50
#define	INTMASK 		 0x8
#define	EDGE		     0xC

#define	IRQ_KEYS		 73

void *lwbridgebase;
void *ledr_addr, *key_addr;



irq_handler_t irq_handler(int irq, void	*dev_id, struct	pt_regs	*regs)
{
	int press, value;

	press = ioread32(key_addr + EDGE);
	iowrite32(0xf, key_addr + EDGE);

	value ^= press;
	iowrite32(value, ledr_addr);	

	return (irq_handler_t) IRQ_HANDLED;
}

static int __init intitialize_pushbutton_handler(void)
{
	
	lwbridgebase = ioremap_nocache(LW_BRIDGE_BASE, LW_BRIDGE_SPAN);
	ledr_addr =	lwbridgebase + LEDR_BASE;
	key_addr =	lwbridgebase + KEY_BASE;

	iowrite32(0x200, ledr_addr); 
	iowrite32(0xf, key_addr	+ INTMASK);
	iowrite32(0xf, key_addr + EDGE);
				
	return request_irq(IRQ_KEYS, (irq_handler_t)irq_handler,
				IRQF_SHARED, "pushbutton_irq_handler",
                (void *)(irq_handler));
}

static void __exit cleanup_pushbutton_handler(void)
{
	iowrite32(0x0,	ledr_addr);
	free_irq(IRQ_KEYS,	(void*)	irq_handler);
}
module_init(intitialize_pushbutton_handler);
module_exit(cleanup_pushbutton_handler);