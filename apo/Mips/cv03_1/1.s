#define t0 $8
#define t1 $9
#define t2 $10

#define s0 $16
#define s1 $17
#define s2 $18

.globl start
.set noat
.ent start

start:
addi s0, $0, 0x01
addi s1, $0, 0x01
add  s2, s0, s1

nop
.end start