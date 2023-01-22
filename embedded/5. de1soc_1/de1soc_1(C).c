//fpga_gpio1.c
int main(void) {
	volatile int *LEDs      = (int *) 0xff200000;
	volatile int *SW_switch = (int *) 0xff200040;
	
	while(1) {
		int value;
		
		value = *SW_swich;
		*LED = value;
	}
}
		

//fpga_gpio2.c
int main(void)
{
	volatile int *LEDs 	    = (int *) 0xFF200000;
 	volatile int *HEX3_HEX0 = (int *) 0xFF200020;
	volatile int *SW_switch = (int *) 0xFF200040;
	int hex_conversions[16] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 
						0x7D, 0x07, 0x7F, 0x67, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
	
	while(1)
	{
	int value = *SW_switch;
	*LEDs = value;
	int first_digit = value & 0xF;
	int second_digit = (value >> 4) & 0xF;
	int third_digit = (value >> 8) & 0xF;
	int hex_value = hex_conversions[first_digit];
	hex_value |= hex_conversions[second_digit] << 8;
	hex_value |= hex_conversions[third_digit] << 16;
	*HEX3_HEX0 = hex_value;
	}
}
