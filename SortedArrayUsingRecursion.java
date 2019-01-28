public class SortedArrayUsingRecursion{

     public static void main(String []args){
        int[] arr = new int[]{2,4,5,6,7,8,9,10,12,14};
        System.out.println(isArraySorted(arr,0));
     }
     
     private static int isArraySorted(int[] arr, int index){
      if(index == arr.length -1){
          return 1;
      }   
      
      if(arr[index]>arr[index+1])
      {
          return 0;
      }
      else{
          return isArraySorted(arr, index+1);
      }
         
     }
}