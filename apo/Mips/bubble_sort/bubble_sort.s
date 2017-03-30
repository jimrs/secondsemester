#define t0 $8	// N-1
#define t1 $9	// N-1-i
#define t2 $10	// tmp
#define t3 $11
#define t4 $12
#define t5 $13
#define t6 $14
#define t7 $15

#define s0 $16	// pole
#define s1 $17	// N
#define s2 $18	// i
#define s3 $19	// j
#define s4 $20	// pole[j]
#define s5 $21	// pole[j+1]
#define s6 $22

.globl    pole
.data
.align    2

pole:
.word    5,3,4,1,2

.text
.globl start
.ent start

start:
la s0, pole		// adresa pole do registru s0
addi s1, $0, 5	// int N = 5
addi s2, $0, 0	// int i = 0
addi s3, $0, 0	// int j = 0

outerfor:
	bge s2, s1, done	// pokud i >= N, done
	innerfor:
		addi t0, s1, -1	// t0 = N-1
		sub t1, t0, s2	// t1 = N-1-i
		bge s3, t1, outerend	// pokud j >= N-1-i, outerend
		lw s4, 0x0(s0)	// pole[j]
		lw s5, 0x4(s0)	// pole[j+1]
		bge s5, s4, innerend	// pokud pole[j+1] >= pole[j] innerend
		add t2, $0, s5	// tmp = pole[j+1]
		sw s4, 0x4(s0)	// pole[j+1] = pole[j]
		sw t2, 0x0(s0)	// pole[j] = tmp	
		innerend:
			addi s3, s3, 1	// j++
			addi s0, s0, 4	// posun v poli pro prikazy lw
			j innerfor
	outerend:
		addi s2, s2, 1	// i++
		addi s3, $0, 0	// j = 0
		la s0, pole		// adresa modifikovaneho pole do registru s0, neni optimalni z hlediska rychlosti, bude projizdet i uz serazene prvky pole
		j outerfor
done:
	lw t3, 0x0(s0)	// vypis pro kontrolu
	lw t4, 0x4(s0)
	lw t5, 0x8(s0)
	lw t6, 0xC(s0)
	lw t7, 0x10(s0)
nop
.end start