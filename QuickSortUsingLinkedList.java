package quicksortusinglinkedlist;
import java.util.*;
class nodes{
    int data;
    nodes next = null;
}

public class QuickSortUsingLinkedList {
    static nodes partition(nodes left, nodes right){     
        nodes big = left;
        nodes pivot = right;
        while(big.data<pivot.data && big!=pivot){
            big = big.next;
        }        
        if(big==pivot) return big;
        nodes small = big.next;   
        while(small!=pivot){
            if(small.data<pivot.data){
                int n = small.data;
                small.data = big.data;
                big.data = n;
                big = big.next;
            }
            small = small.next;
        }
        int n = big.data;
        big.data = pivot.data;
        pivot.data = n;
        return big;
    }
    static void quickSort(nodes left,nodes right){
        if(left==right) return;
        if(left==null || right==null) return;
        
        nodes pivot = partition(left,right);
        
        if(left!=pivot) {
            nodes temp = left;
            while(temp.next!=pivot) temp = temp.next;
            quickSort(left, temp);  
        }
        if(pivot!=right)
            quickSort(pivot.next, right);        
    }
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Number of inputs: ");
        int n = in.nextInt();
        System.out.print("Input datas: ");        
        
        nodes head = null;        
        nodes prev = null;

        for(int i=0;i<n;i++){
            nodes newnodes = new nodes();
            newnodes.data = in.nextInt();
            newnodes.next = null;
            if(i==0){
                head = newnodes;
            }
            else prev.next = newnodes;
            prev = newnodes;
        }        
        nodes tail = head;   
        while(tail.next!=null)tail = tail.next;
        
        quickSort(head,tail);
        
        System.out.print("Sorted array -> ");
        nodes temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println("\n");
    }
    
}
