
/*
Array

1. Array represents adjacent memory location storing same type of data object

2. representing string using array
see ASCIL
null terminated string
"Harry Potter" = Harry Potter\0  -> 72 97 114 114 121 32 80 111 116 116 101 114 0



*/
int big_array[128]; // allocates 512 adjacent bytes in memory at 0x0000
int* array_ptr;


// big_array + i = &big_array[i] = &big_array[0] + i*sizeof(big_array[0])

// pointing at the start of array, since this is declared as an array
// c knows not meaning the value as there are 128 values 
// i.e. address of first location
array_ptr = big_array; // 0x0000
array_ptr = &big_array[0]; // same as pointing at the start of array, 0x0000
array_ptr = &big_array[3]; // 0x000c
array_ptr = &big_array[0]+3; // 0x000c, + 3 * sizeof(int), c knows when adding to ptr, dont mean the value
array_ptr = &big_array + 3; // 0x000c
*array_ptr = *array_ptr + 1; // increment the value at 4th element of the array at index 3
array_ptr = big_array[130]; // 0x0208, point to out of bound, but C doesnt care, give you back the location





// "Harry Potter" = Harry Potter\0  -> 72 97 114 114 121 32 80 111 116 116 101 114 0
char HP[13] = "Harry Potter";
char null_string = HP[13]; // "\0"

/* 
cse 351 array lecture 
printing address + hex representation of value
*/
#include <stdio.h>

void show_bytes(int* p, int len){
	
	for (int i = 0; i < len; ++i)
	{
		// %x: hex %p: pointer *(p+1):gabbage value 
		// \t:tab \n:newline %.5x: shows 5 digits of hex value
		printf("%p\t%.5x\t%x\n", p+i, *(p+i), *(p+i));

	};

};

void show_int(int x){
	// (char*) &x 
	show_bytes((int*) &x, sizeof(int));
}

int main(int argc, char const *argv[])
{
	int a = 12345; // hex representation of the value-> 0x00003039
	int* pointer = &a; // have to initialize pointer
	show_bytes(pointer, 10); // print ptr addr + value
	printf("here is show_int\n");
	show_int(a);

	return 0;
}


/*

Bit-level operator
& intersection
| union
^ symmetric difference
~ complement

Logic operator &&, ||, !
anything non-zero is true
zero is always false 
false only if entire int vector is zero 

null pointer = 0x00000000
if (p && *p++) // is equal to if (p) {*p++};

*/

// bitwise operator &, |, ^, ~


char a,b,c,d,e;
a = (char) 0x00; // 00000000
b = ~a; // 11111111
a = (char)0x41; // 0x41 = 01000001
b = ~a; // 10111110 = 0xBE
b = (char) 0x55; //0x55 = 01010101
c = a | b; // 0x55 01010101
d = a & b; // 0x41 01000001
e = a ^ b; // 11101011



/*
Section 3

1. ISA (instruction set architecture)
e.g. x86 ISA 
CISC i.e. complex instruction set computer

- interface between hardware and software
- set of instructions to compiler to machine code 
- defines system's state (e.g. program counter, registers, all contents of memory)
	>> program counter: instruction/program that is being executed 
- defines instructions CPU can execute 
	>> e.g. add, sub, mov
- defines effect of each of instruction have on system state
- encoding is mapping between add -> 10101 (instruction -> bit sequence that determines that instruction)




2. C, Assembly, Machine code

3. Registers 
- basic unit of storage inside CPU
- width of registers -> 32 bits vs 64 bits



*/


