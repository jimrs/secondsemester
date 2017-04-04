

#define s0 $16
#define s1 $17
#define s2 $18

.globl    pole
.data
.align    2

pole:
.word    1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
.text
.globl start
.ent start

start:

la   s0, pole       // adresa zacateku pole do registru s0
addi s1, $0, 3      // Pocet pruchodu cyklem (pocet iteraci)
nop                 // Proc je zde nop? Zkuste jej odranit.. Zmeni se hit rate?

loop:
    beq s1,$0, konec
    lw s2, 0(s0)      // Cteni 0-teho prvku pole
    lw s2, 4(s0)      // Cteni 1. prvku (4/4=1)

    lw s2, 36(s0)     // Cteni 9. prvku (36/4=9)
    lw s2, 40(s0)     // Cteni 10.prvku (40/4=10)
   
    addi s1, s1, -1
    j loop

konec:
nop  

end_loop:           //Koncova nekonecna smycka
    j end_loop
    nop

.end start
