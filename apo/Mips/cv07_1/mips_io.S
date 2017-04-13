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
lui s0, 0xbf90
lui s1, 0x0100 
sw s1, 0x0(s0)

nop
.end start
