
#define zero	$0
#define AT	$1
#define v0 	$2
#define v1	$3
#define a0	$4
#define a1	$5
#define a2	$6
#define	a3	$7

#define t0	$8
#define t1	$9
#define t2	$10
#define t3	$11
#define t4	$12
#define t5	$13
#define t6	$14
#define t7	$15
#define t8	$24
#define t9	$25
#define k0	$26
#define k1	$27

#define s0	$16
#define s1	$17
#define s2	$18
#define s3	$19
#define s4	$20
#define s5	$21
#define s6	$22
#define s7	$23

#define gp	$28
#define sp	$29
#define fp	$30
#define ra	$31

.globl start
.globl _start
.set noat
.ent start
.set noreorder

start:
_start:
  nop
  nop
  nop
  nop
  nop
  addi t0,$0,0
  addi t1,$0,0
  addi t2,$0,0
  addi t3,$0,0
  addi t4,$0,0
  addi t5,$0,0
  addi t6,$0,0
  addi t7,$0,0
  addi t8,$0,0
  addi s1,$0,0x1111
  addi s2,$0,0x2222
  addi s3,$0,0x3333
  addi s4,$0,0x4444
  addi s5,$0,0x5555
  nop
  nop
  nop
_test:
  addi t0,s1,0
  addi s1,s1,0x22
  add  t1,$0,s1
  add  t2,$0,s1
  add  t3,$0,s1
  beq  $0,$0,skip
  add  t5,$0,s1
  add  t6,$0,s1
  add  t7,$0,s1
  add  t8,$0,s1
skip:
  nop
.end start
