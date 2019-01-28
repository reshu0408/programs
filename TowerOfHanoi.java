public class TowerOfHanoi{

     public static void main(String []args){
        TowerOfHanoi obj = new TowerOfHanoi();
        obj.towerOfHanoi(3, 'A', 'B','C');
     }
     
     
     private void towerOfHanoi(int n, char from, char aux, char to){
         
        if(n==1){
            System.out.println("Move ring from " + from + " to " + to);
            return;
         }
         
        towerOfHanoi(n-1, from, to, aux);
         
        System.out.println("Move ring from " + from + " to " + to);

        towerOfHanoi(n-1, aux, from,to);
     }
}