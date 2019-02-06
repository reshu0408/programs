import java.util.*;
public class SingleLinkedList{

    private static int length = 0;
    private static ListNode head;

    public static void main(String []args){
        
        ListNode node1 = new ListNode();
        node1.setData(10);
        ListNode node2 = new ListNode();
        node2.setData(20);
        ListNode node3 = new ListNode();
        node3.setData(30);
        ListNode node4 = new ListNode();
        node4.setData(40);
        ListNode node5 = new ListNode();
        node5.setData(50); 
        ListNode node6 = new ListNode();
        node6.setData(60);
        
        head = node1;
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(null);
        traverse();
        lengthOfList();
        
        //insert new node at beginning
        ListNode newNode = new ListNode();
        newNode.setData(5);
        newNode.setNext(null);
        insertAtBeginning(newNode);
        System.out.println("insert 15 at beginning");
        traverse();

         //insert new node at end
        ListNode newNodeAtEnd = new ListNode();
        newNodeAtEnd.setData(70);
        newNodeAtEnd.setNext(null);
        insertAtEnd(newNodeAtEnd);
        System.out.println("\ninsert 70 at end");
        traverse();
        
         //insert new node at given position
        ListNode newNodeAtMiddle = new ListNode();
        newNodeAtMiddle.setData(35);
        newNodeAtMiddle.setNext(null);
        insertAtPosition(newNodeAtMiddle,4);
        System.out.println("\ninsert 35 at position 4");
        traverse();

        //remove node from beginning
        removeFromBegin();
        System.out.println("\nRemove node from beginning");
        traverse();
        
         //remove node from beginning
        removeFromEnd();
        System.out.println("\nRemove node from end");
        traverse();
        
         //remove Matching node
        ListNode nodeMatching =  new ListNode();
        nodeMatching.setData(40);
        removeMatching(nodeMatching);
        System.out.println("\nRemove node Matching to 40");
        traverse();
        
         //remove at position
        removeAtPosition(3);
        System.out.println("\nRemove node at position 3");
        traverse();
        
         //get position
        System.out.println("\nGet position of element 30  = " + getPosition(30));
    }
    
    private static void traverse() {
        ListNode temp = head;
        
        while(temp != null){
             System.out.print(temp.getData());
             if(temp.getNext() != null){
               System.out.print(" --->> ");
             }
             temp = temp.getNext();
        }
    }
    
    private static void lengthOfList(){
        ListNode temp = head;
        length = 0;
        
        while(temp != null){
             length++;
            temp = temp.getNext();
        }
        temp = null;
        System.out.println("\nlength = " + length);
    }
    
    private static void insertAtBeginning(ListNode newNode){
        newNode.setNext(head);
        head = newNode;
        length++;   
    }
    
    private static void insertAtEnd(ListNode newNodeAtEnd){
        if(head == null){
            head = newNodeAtEnd;
        }
        
        ListNode temp = head;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(newNodeAtEnd);
        length++;
    }
    
    private static void insertAtPosition(ListNode newNodeAtPosition, int position){
        if(position<0){
            position = 0;
        }
        else if(position > length){
            position = length;
        }
        
        if(head == null){
            head = newNodeAtPosition;
            return;
        }
        else if(position == 0){
            newNodeAtPosition.setNext(head);
            head = newNodeAtPosition;
        }else{
            int i = 0;
            ListNode temp = head;
            while(i<position-1){
                temp = temp.getNext();
                i++;
            }
            
            newNodeAtPosition.setNext(temp.getNext());
            temp.setNext(newNodeAtPosition);
            temp = null;
        }
        length++;
        
    }
    
    private static void removeFromBegin(){
         if(head == null)
            return;
        ListNode temp = head;
        head = temp.getNext();
        temp = null;
        length--;
    }
    
    private static void removeFromEnd(){
        ListNode temp = head;
        ListNode nodeToBeDeleted;
        if(head == null)
            return;
        else if(head.getNext() == null){
            head  = null;
        }else{
            while(temp.getNext().getNext() != null){
                temp = temp.getNext();
            }
            nodeToBeDeleted = temp.getNext();
            temp.setNext(null);
            nodeToBeDeleted = null;
            temp = null;
        }
        length--;
         
    }
    
    private static void removeMatching(ListNode nodeToBeDeleted){
        if(head == null)
            return;
        else if( head.getNext() == null && head.getData() == nodeToBeDeleted.getData()){
            head = null;
        }
        else{
            ListNode temp = head;
            while(temp.getNext() != null && temp.getNext().getData() != nodeToBeDeleted.getData()){
                temp = temp.getNext();
            }
            
            if(temp == null){
              System.out.println("\nNo matching node");
            }else{
                ListNode temp1 = temp.getNext();
                temp.setNext(temp.getNext().getNext());
                temp1 = null;
            }
        }
        length--;
    }
    
    private static void removeAtPosition(int position){
        if(position < 0){
            position = 0;
            removeFromBegin();
            return;
        }
        else if(position > length){
            position = length;
            removeFromEnd();
            return;
        }
        
        ListNode temp = head;
        int i = 0;
        
        while(i< position -1){
            temp = temp.getNext();
            i++;
        }
        
        ListNode temp1 = temp.getNext();
        temp.setNext(temp1.getNext());
        temp1 = null;
        temp = null;
        length--;
    }
    
    private static int getPosition(int data){
        int position = 1;
        if(head == null) 
            return -1;
        ListNode temp = head;
        while(temp != null){
            if(temp.getData() == data){
                return position;
            }
            position++;
            temp = temp.getNext();
        }
        return -1;
        
    }
    
    static class ListNode{
        private int data;
        private ListNode next;
        
        public int getData(){
            return this.data;
        }
        
        public void setData(int data){
            this.data = data;
        }
        
        public ListNode getNext(){
            return this.next; 
        }
        
        public void setNext(ListNode next){
            this.next = next;
        }
    }
}
