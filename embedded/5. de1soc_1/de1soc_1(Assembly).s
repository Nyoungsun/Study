//fpga_gpio.s
.text
.global _start
_start:
		ldr r0, =0xff200000
		ldr r1, =0xff200040
LOOP:
		ldr r3, [r1]
		ldr r3, [r0]
		b loop
END:
		b end
.end
	

//jtag_uart.s
.equ DDR_HIGH_WORD, 0x3FFFFFFC
.text
.global _start
_start:
		MOV SP, #DDR_HIGH_WORD
		LDR R4, =TEXT_STRING
LOOP:
		LDRB R0, [R4]
		CMP R0, #0
		BEQ CONT
		
		BL PUT_JTAG
		ADD R4, R4, #1
		B LOOP
CONT:
		BL GET_JTAG
		CMP R0, #0
		BEQ CONT
		BL PUT_JTAG
		B CONT
		
.global PUT_JTAG
PUT_JTAG:
		LDR R1, =0xFF201000
		LDR R2, [R1, #4]
		LDR R3, =0xFFFF0000
		ANDS R2, R2, R3
		BEQ END_PUT
		STR R0, [R1]
END_PUT:
		BX LR
.global GET_JTAG
GET_JTAG:
		LDR R1, =0xFF201000
		LDR R0, [R1]
		ANDS R2, R0, #0x8000
		BEQ RET_NULL
		AND R0, R0, #0x00FF
		B END_GET
		RET_NULL: MOV R0, #0
END_GET: BX LR

TEXT_STRING:
		.asciz "\nJTAG UART example code \n> "
		.end