import java.util.*;
public class PrintArrayOfNBits{

    private static int[] storeArray;
    public static void main(String []args){
         
        int n = 3;
        storeArray = new int[n];
        binary(n);
    }
    
    private static void binary(int n){
     if(n<1){
         System.out.println(Arrays.toString(storeArray));
     }   
     else{
         storeArray[n-1] = 0;
         binary(n-1);
         storeArray[n-1] = 1;
         binary(n-1);
     }    
    }
}