/*
5-28-2016
Pointer Review


*/

/*
EXAMPLE 1
Pointer typecasting, pointer arithmetic, void pointer
Reference: https://www.youtube.com/watch?v=JTttg85xsbo
 
Pointer is strongly typed, i.e. int ptr could only point to int data type
Why strong type not some generic type?
Because we need to dereference to access / modify value
*/

#include<stdio.h>
int main()
{

int a = 1025;
char b = k;
int* int_p;
int_p = &a; // & means the address of, storing address of a in p
// int_p = &b; //compilation error, strong typed, int ptr cannot point to char data type

printf("size of int %d", sizeof(int)); // sizeof(data_type) 
printf(int_p); // 0x89473984 i.e. a's address
printf(a); // 1025
printf(*int_p); // look at 4 bytes starting at 0x8947xxxxxxxxxx i.e. 1025
printf(int_p + 1); // a's address + 4 bytes i.e. 0x8947xxxxxx + 4 
printf(*int_p + 1); // 1026
printf(*(int_p + 1)); // some random value

char* char_p;
//char_p = int_p; // this is give compilation error 
char_p = (char*) int_p; // char ptr pointing to address of int ptr + type cast int ptr to char ptr
printf(*char_p); // value = 1 since only printing 1 byte from address 0x8947xxxxxx
printf(char_p); // a's address i.e. 0x8947xxxxxx
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
EXAMPLE 2
Pointer to Pointer

& means the address of
* means goes to the address it is pointing to, and then gets the value 
printf(a) means the value of 

*/

#include<stdio.h>

int main(){

int a = 1025;
int* int_p;
int_p = &a;
int** int_pp; 
int_pp = &int_p; // int ptr ptr to int ptr to a's address
int*** int_ppp;
// int_ppp = &a; // ERROR as a is int, int*** could only point to int**
int_ppp = &int_pp;

printf("value of int a %d", *int_p); // 1025
printf("value of int_p %d", *int_pp); // value of int_p is address of a 
printf("value of int_pp %d", *int_ppp); // address of int_pp 
printf(*(*int_pp)); // 1025


}

/*
EXAMPLE 3
using pointer to print array

Reference: Learn C ex. 15

*/

//TODO: your code


/*
EXAMPLE 4
Creating Struct on the heap with malloc and pointer

Struct allows you to pass compound data type into function and access individual parts
e.g. void print_name(struct person* who) printf(who->name); printf(who->age); etc.
1. get the base address of this data type block of memory
2. look up who->name starting address
3. dereference in char* type to get the value

*/

//TODO: your code

/*
EXAMPLE 5
Heap and Stack Memory Allocation

*/


/*
EXAMPLE 6
Malloc, Realloc, Calloc

Reference: mycodeschool https://www.youtube.com/watch?v=xDVC3wKjS64

void* malloc(size_t size)
// _t means typedef/type i.e. size_t is the type used to specify memory size
// typedef unsigned int size_t // rename unsigned int to size_t

void* generic_p = malloc(size_t size)
*generic_p = 2 // ERROR since cannot dereference void* 

struct Person* who = malloc(sizeof(struct Person)); //malloc returns a void pointer to the 1st byte
// assign the address of 1st byte to struct_person_ptr
int* int_p = (int*)malloc(3*sizeof(int));
*int_p = 2;
*(int_p+1) = 3; // goes to 1st byte of malloc address + 4 bytes, gets the value and then assign 3 to it
int_p[2] = 4;
*(int_p+3) = 5;


// malloc does not initialize the blocks
// calloc initialize to all byte position to 0
void* calloc (size_t numElem, size_t sizeDataType)
int* int_p = (int*)calloc(3, sizeof(int));
 



*/

