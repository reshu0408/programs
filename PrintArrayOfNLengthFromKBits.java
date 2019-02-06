import java.util.*;
public class PrintArrayOfNLengthFromKBits{

    private static int[] storeArray;
    public static void main(String []args){
         
        int n = 3;
        int k = 3;
        storeArray = new int[n];
        k_nary(n , k);
    }
    
    private static void k_nary(int n, int k){
     if(n<1){
         System.out.println(Arrays.toString(storeArray));
     }   
     else{
         
         for(int i = 0 ; i<k; i++){
             storeArray[n-1] = i;
             k_nary(n-1, k);
         }
     }    
    }
}