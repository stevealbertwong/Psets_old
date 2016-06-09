
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

// printing data


