#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

#include <sys/types.h>
#include <sys/ioctl.h>
#include <sys/stat.h>

int main(void) {
    int dev, data, rdata;

    dev = open("/dev/keys", O_RDONLY);
    if (dev <0) {
        fprintf(stderr, "cannot open KEY button device\n");
        return 1;
    }
    read(dev, &rdata, 4);
    printf("key data = %x\n", rdata);
    return 0;
}