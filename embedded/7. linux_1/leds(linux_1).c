#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <signal.h>

#define HW_REGS_BASE ( 0xff200000 )
#define HW_REGS_SPAN ( 0x00200000 )
#define HW_REGS_MASK ( HW_REGS_SPAN - 1 )
#define LED_PIO_BASE 0x0
#define SW_PIO_BASE  0x40

volatile sig_atomic_t stop = 0;

void catchSIGINT(int signum) {
    stop = 1;
}

int main(void)
{
    volatile unsigned int *h2p_lw_led_addr=NULL;
    volatile unsigned int *h2p_lw_sw_addr=NULL;
    void *virtual_base;
    int fd;


signal(SIGINT, catchSIGINT);

if((fd=open("/dev/mem", (O_RDWR | O_SYNC)))== -1){
    printf("ERROR: could not open \"/dev/mem\"...\n");
    return 1;
}

virtual_base =mmap(NULL, HW_REGS_SPAN, ( PROT_READ | PROT_WRITE), MAP_SHARED,
fd, HW_REGS_BASE);
if (virtual_base == MAP_FAILED) {
    printf("ERROR: mmap() failed...\n");
    close(fd);
    return(1);
}

h2p_lw_led_addr=(unsigned int *)(virtual_base+((LED_PIO_BASE) & (HW_REGS_MASK)));
h2p_lw_sw_addr=(unsigned int *)(virtual_base+((SW_PIO_BASE) & (HW_REGS_MASK)));

printf("Running leds. To exit, press Ctrl+C.\n");

while(!stop) {
    *h2p_lw_led_addr = *h2p_lw_sw_addr;
}

if(munmap( virtual_base, HW_REGS_SPAN) != 0) {
    printf ("ERROR: munmap() failed\n");
    close(fd);
    return (1);   
}
close (fd);
return 0;
}