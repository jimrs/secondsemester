/* Simple program to examine how are different data types encoded in memory */

#include <stdio.h>

/*
 * The macro determines size of given variable and then
 * prints individual bytes of the value representation
 */
#define PRINT_MEM(a) print_mem((unsigned char*)&(a), sizeof(a))

void print_mem(unsigned char *ptr, int size) {
  int i;
  printf("address = 0x%08lx\n", (long unsigned int)ptr);

  for (i = 0; i < size; i++) {
    printf("0x%02x ", *(ptr+i));
  }

  printf("\n");
}

int main() {
  /* try for more types: long, float, double, pointer */
  unsigned int unsigi = 5;
  int sigi = -5;
  
  unsigned long unsigl = 5;
  long sigl = -5;
  
  float unsigf = 5.0;
  float sigf = -5.0;
  
  double unsigd = 5.0;
  double sigd = -5.0;

  /* Read GNU C Library manual for conversion syntax for other types */
  /* https://www.gnu.org/software/libc/manual/html_node/Formatted-Output.html */
  printf("value = %d\n", unsigi);
  PRINT_MEM(unsigi);

  printf("\nvalue = %d\n", sigi);
  PRINT_MEM(sigi);
  
  printf("value = %d\n", unsigl);
  PRINT_MEM(unsigl);

  printf("\nvalue = %d\n", sigl);
  PRINT_MEM(sigl);
  
  printf("value = %f\n", unsigf);
  PRINT_MEM(unsigf);

  printf("\nvalue = %f\n", sigf);
  PRINT_MEM(sigf);

  return 0;
}
