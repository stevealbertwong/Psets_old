/*
5-28-2016
Pointer Review

Reference: https://www.youtube.com/watch?v=JTttg85xsbo
*/

/*
EXAMPLE 1
Pointer typecasting, pointer arithmetic, void pointer
*/

#include<stdio.h>
int main()
{

int a = 1025;
int* int_p;
int_p = &a; // store address of a in p

printf("size of int %d", sizeof(int)); // sizeof(data_type) 
printf(int_p); // 0x8947398471398 i.e. address
printf(a); // 1025
printf(*int_p); // look at 4 bytes starting at 0x8947xxxxxxxxxx i.e. 1025
printf(int_p + 1); // address + 4 bytes i.e. 0x8947xxxxxx + 4 
printf(*int_p + 1); // 1026
printf(*(int_p + 1)); // some random value

char* char_p;
//char_p = int_p; // this is give compilation error 
char_p = (char*) int_p; // char ptr pointing to address of int ptr + type cast int ptr to char ptr
printf(*char_p); // value = 1 since only printing 1 byte from address 0x8947xxxxxx
printf(char_p); // address i.e. 0x8947xxxxxx
printf(*(char_p + 1); // 4 -> 1025 = 00000000 00000000 00000100 00000001
printf(char_p + 1); // 0x8947xxxxx + 1

(int*) char_p = int_p;

void* generic_p; // does not correspond to any data type
generic_p = int_p // no compilation error -> no need to typecast, not mapped to particula data type
printf(generic_p) // 0x8947xxxxxx
printf(*generic_p) // ERROR -> CANNOT DEREFERENCE
printf(generic_p + 1) // ERROR -> CANNOT DEFERENCE
printf (*(generic_p + 1) // 

 
}


/*

Pointer is strongly typed, i.e. int* for int variable
Why strong type not some generic type?
Because we need to dereference to access / modify value	


*/
