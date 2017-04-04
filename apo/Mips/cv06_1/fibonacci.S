#define t0 $8
#define t1 $9
#define t2 $10

#define s0 $16
#define s1 $17
#define s2 $18

.globl start
.set noat
.set noreorder
.ent start

start:
addi t0, $0, 5
addi s0, $0, 0
addi s1, $0, 1		//inicializace promennych

addi t1, $0, 2		
bne t1, t0, for	//podminky for cyklu

for:
	add t2, s0, s1
	add s0, $0, s1
	add s1, $0, t2

	addi t1, t1, 1	
	bne t1, t0, for	//podminky for cyklu

nop
addi s1, s1, 15

end_loop:           //Koncova nekonecna smycka
    j end_loop
    nop
.end start
