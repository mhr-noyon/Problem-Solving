package mergesortusinglinkedlist;
import java.util.*;

class nodes{
    int data;
    nodes next = null;
}

public class MergeSortUsingLinkedList {
     static void merge(nodes curnodes,int l, int mid, int r){
        int lsize = mid - l + 1;
        int rsize = r - mid;
        nodes leftHead = null;        
        nodes rightHead = null;          
  
        int ind = 1;
        while(ind!=l){
            curnodes = curnodes.next;
            ind++;
        }
        nodes actualnodes = curnodes;
        
        nodes prev = null; 
        for(int i=l; i<=mid ; i++){
            nodes newnodes = new nodes();
            newnodes.data = actualnodes.data;               
            newnodes.next = null;    
            
            if(i==l) leftHead = newnodes;
            else prev.next = newnodes;
            actualnodes = actualnodes.next;
            prev = newnodes;
        }
        prev = null;
        for(int i=mid+1; i<=r ; i++){
            nodes newnodes = new nodes();
            newnodes.data = actualnodes.data;                
            newnodes.next = null;    
             
            if(i==mid+1) rightHead = newnodes;
            else prev.next = newnodes;
            actualnodes = actualnodes.next;
            prev = newnodes;
        }
        
        
        while(leftHead!=null && rightHead!=null){
            if(leftHead.data<rightHead.data){
                curnodes.data = leftHead.data;
                leftHead = leftHead.next;
            }
            else{
                curnodes.data = rightHead.data;
                rightHead = rightHead.next;
            }
            curnodes = curnodes.next;
        }
        while(leftHead!=null){
            curnodes.data = leftHead.data;
            leftHead = leftHead.next;
            curnodes = curnodes.next;
        }
        while(rightHead!=null){
            curnodes.data =  rightHead.data;
            rightHead = rightHead.next;
            curnodes = curnodes.next;
        }
    }
     static void mergeSort(nodes curnodes,int l,int r){
        if(l==r) return;
        int mid = (l+r)/2;
        mergeSort(curnodes,l,mid);        
        mergeSort(curnodes,mid+1,r);
        merge(curnodes,l,mid,r);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.print("Number of inputs: ");
        int n = in.nextInt();
        int[] arr= new int[n];
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
        mergeSort(head,1,n);
        System.out.print("Sorted array -> ");
        nodes temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println("\n");
    }
    
}
