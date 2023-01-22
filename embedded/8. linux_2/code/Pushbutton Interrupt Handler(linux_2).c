include<linux/kernel.h>
#include <linux/module.h>
#include <linux/init.h>
#include <linux/interrupt.h>
#include <asm/io.h>

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Altera University Program, modified by skyun");
MODULE_DESCRIPTION("DE1SoC Pushbutton Interrupt Handler");
#define LW_BRIDGE_BASE 0xFF200000

#define LW_BRIDGE_SPAN 0x00200000
#define LEDR_BASE 0x00
#define KEY_BASE 0x50
#define INTMASK 0x8
#define EDGE 0xC

#define IRQ_KEYS 73

void *lwbridgebase;
void *ledr_addr, *key_addr;

irq_handler_t irq_handler(int irq, void *dev_id, struct pt_regs *regs)
{
int value;

// Increment the value on the LEDs
value = ioread32(ledr_addr);
iowrite32(value + 1, ledr_addr);
// Clear the edgecapture register (clears current interrupt)
iowrite32(0xf, key_addr + EDGE);

return (irq_handler_t) IRQ_HANDLED;
}

static int __init intitialize_pushbutton_handler(void)
{
// get the virtual addr that maps to 0xff200000
lwbridgebase = ioremap_nocache(LW_BRIDGE_BASE, LW_BRIDGE_SPAN);
ledr_addr = lwbridgebase + LEDR_BASE;
key_addr = lwbridgebase + KEY_BASE;
// Set LEDs to 0x200 (the leftmost LED will turn on)
iowrite32(0x200, ledr_addr); // 0x200 = 1<<9
// Clear the PIO edgecapture register (clear any pending interrupt)
iowrite32(0xf, key_addr + INTMASK);
// Enable IRQ generation for the 4 buttons
iowrite32(0xf, key_addr + EDGE);
// Register the interrupt handler.
return request_irq(IRQ_KEYS, (irq_handler_t)irq_handler,
IRQF_SHARED, "pushbutton_irq_handler",
(void *)(irq_handler));
}

static void __exit cleanup_pushbutton_handler(void)
{
// Turn off LEDs and de-register irq handler
iowrite32(0x0, ledr_addr);
free_irq(IRQ_KEYS, (void*) irq_handler);
}

module_init(intitialize_pushbutton_handler);
module_exit(cleanup_pushbutton_handler);
