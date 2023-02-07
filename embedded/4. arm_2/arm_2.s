.global _start
	
_start:
		mov r0, #data1
		ldr r1, [r0]
		ldr r2, [r0. #4]
		ldr r3, [r0], #4
		ldr r4, [r0, #4]!
		
		ldr r0, =#data1
		mov r0, #12
		ldr r5, [r0, r1]
		mov r1, #3
		ldr r6, [r0, r1, lsl#2]

stop:
		b stop
		
data1: .word 1, 2, 3, 4, 5, 6, 7, 8


.global _start
	
_start:
		mov r0, #src
		mov r1, #dst
		ldmia r0, {r2-r9}
		stmia r1!, {r2-r9}
		
		mov sp, #tos
		stmfd sp!, {r2-r9}
		ldmfd sp!, {r2-r9}
		
		mov sp, #tos
		push {r2-r4}
		pop {r2-r4}
		
stop:
		b stop

src: .word 0x1111, 0x2222, 0x3333, 0x4444, 0x5555, 0x6666, 0x7777, 0x8888
dst: .space 20
stack: .space 256
tos: //top of stack


.global _start
_start:
		ldr r0, =#0x10
		ldr r1, =#0x10
		cmp r0, r1
		movgt r2, #1
		movlt r2, #2
		moveq r2, #3
stop:
		b stop


.text
.global _start
_start:
		mov r0, #54
		mov r1, #24
		
GCD:
		cmp r0, r1
		subgt r0, r0, r1
		sublt r1, r1, r0
		bne GCD
stop:
		b stop
	

.text
.global _start
_start:
		ldr r0, N
		bl FINDSUM
		B END
		
FINDSUM:
		movs r1, r0
		mov r0, #0

SUM_LOOP:
		ble END_LOOP
		add r0, r0,r1
		subs r1, #1
		b SUM_LOOP

END_LOOP:
		mov pc, lr
		
N:		.word

.end
	

.text
.global _start
_start:
		ldr r0, N
		bl FINDSUM
END:    
		b END
		
FINDSUM:
		push {r4, lr}
		movs r4, r0
		ble RETURN
RECURSE:
		sub r0, r4, #1
		bl FINDSUM
		add r0, r4, r0

RETURN:
		pop {r4, pc}
		
N:		.word 5
.end
	




	
		
	
	