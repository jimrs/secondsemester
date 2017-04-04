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
default:pipe_test.srec

# executable file:object file.o
pipe_test:pipe_test.o
	$(CC) $(LDFLAGS) $^ -o $@

# all generated that would be cleaned
clean:
	rm -f pipe_test pipe_test.o pipe_test.out pipe_test.srec
