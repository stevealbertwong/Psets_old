package reversearray;
import java.util.*;
import java.io.*;
import java.lang.String;
import java.lang.reflect.Array;

/**
 *
 * @author SteveAndrewWong
 */
public class ReverseArray {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // create array
        // parse poem.txt into lines  + for -- loop
        Array arr <String> = new Array <String>;
        
        Scanner sc = new Scanner(new File(poem.txt));
        while (sc.hasNextLine()){
            int j = number of lines of poem.txt;
            String line = sc.getline();
            arr[j] = line;
            j--;

        for (int i = 0, i > arr.getsize(), i++){
            System.out.print(arr[i]);
        }
    }
    
}
