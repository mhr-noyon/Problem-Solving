package quickSort;
import java.util.*;
class Node{
    int value;
    Node next = null;
}

public class QuickSortUsingLinkedList {
    static void swap(Node a, Node b){
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
    static Node partition(Node left, Node right){     
        Node big = left;
        Node piv = right;
        while(big.value<piv.value && big!=piv){
            big = big.next;
        }        
        if(big==piv) return big;
        Node small = big.next;   
        while(small!=piv){
            if(small.value<piv.value){
                swap(small, big);
                big = big.next;
            }
            small = small.next;
        }
        swap(big,piv);
        return big;
    }
    static void quickSort(Node left,Node right){
        if(left==right) return;
        if(left==null || right==null) return;
        
        Node piv = partition(left,right);
        
        if(left!=piv) {
            Node temp = left;
            while(temp.next!=piv) temp = temp.next;
            quickSort(left, temp);  
        }
        if(piv!=right)
            quickSort(piv.next, right);        
    }
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Number of inputs: ");
        int n = in.nextInt();
        System.out.println("Input values: ");        
        
        Node head = null;        
        Node prev = null;

        for(int i=0;i<n;i++){
            Node newnode = new Node();
            newnode.value = in.nextInt();
            newnode.next = null;
            if(i==0){
                head = newnode;
            }
            else prev.next = newnode;
            prev = newnode;
        }        
        Node tail = head;   
        while(tail.next!=null)tail = tail.next;
        
        quickSort(head,tail);
        
        System.out.print("Sorted array -> ");
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println("\n");
    }
    
}