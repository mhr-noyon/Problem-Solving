package margesort;
import java.util.*;

class Node{
    int value;
    Node next = null;
}

public class MergeSortUsingLinkedList {
     static void merge(Node curNode,int l, int mid, int r){
        int lsize = mid - l + 1;
        int rsize = r - mid;
        Node leftHead = null;        
        Node rightHead = null;          
  
        int ind = 1;
        while(ind!=l){
            curNode = curNode.next;
            ind++;
        }
        Node actualNode = curNode;
        
        Node prev = null; 
        for(int i=l; i<=mid ; i++){
            Node newNode = new Node();
            newNode.value = actualNode.value;               
            newNode.next = null;    
            
            if(i==l) leftHead = newNode;
            else prev.next = newNode;
            actualNode = actualNode.next;
            prev = newNode;
        }
        prev = null;
        for(int i=mid+1; i<=r ; i++){
            Node newNode = new Node();
            newNode.value = actualNode.value;                
            newNode.next = null;    
             
            if(i==mid+1) rightHead = newNode;
            else prev.next = newNode;
            actualNode = actualNode.next;
            prev = newNode;
        }        
        
        while(leftHead!=null && rightHead!=null){
            if(leftHead.value<rightHead.value){
                curNode.value = leftHead.value;
                leftHead = leftHead.next;
            }
            else{
                curNode.value = rightHead.value;
                rightHead = rightHead.next;
            }
            curNode = curNode.next;
        }
        while(leftHead!=null){
            curNode.value = leftHead.value;
            leftHead = leftHead.next;
            curNode = curNode.next;
        }
        while(rightHead!=null){
            curNode.value =  rightHead.value;
            rightHead = rightHead.next;
            curNode = curNode.next;
        }
    }
     static void mergeSort(Node curNode,int l,int r){
        if(l==r) return;
        int mid = (l+r)/2;
        mergeSort(curNode,l,mid);        
        mergeSort(curNode,mid+1,r);
        merge(curNode,l,mid,r);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Number of inputs: ");
        int n = in.nextInt();
        int[] arr= new int[n];
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
        mergeSort(head,1,n);
        System.out.print("Sorted array -> ");
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println("\n");
    }
    
}