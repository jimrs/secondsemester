ARCH=mips-elf

CC=$(ARCH)-gcc
AS=$(ARCH)-as
LD=$(ARCH)-ld
OBJCOPY=$(ARCH)-objcopy

CFLAGS  += -ggdb -O1
AFLAGS  += -ggdb
LDFLAGS += -ggdb
LDFLAGS += -nostdlib -nodefaultlibs -nostartfiles
LDFLAGS += -Wl,-Ttext,0x80020000

all:default

.PHONY:clean

%.srec:%
	$(OBJCOPY) -O srec $< $@

%.out:%
	$(OBJCOPY) -O ecoff-bigmips $< $@

%.o:%.S
	$(CC) -D__ASSEMBLY__ $(AFLAGS) -c $< -o $@

%.s:%.c
	$(CC) $(CFLAGS) $(CPPFLAGS) -S $< -o $@

%.o:%.c
	$(CC) $(CFLAGS) $(CPPFLAGS) -c $< -o $@

# default output
default:fibonacci.srec

# executable file:object file.o
fibonacci:fibonacci.o
	$(CC) $(LDFLAGS) $^ -o $@

# all generated that would be cleaned
clean:
	rm -f fibonacci fibonacci.o fibonacci.out fibonacci.srec
