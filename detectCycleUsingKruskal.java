package kruskal;
import java.util.Scanner;
public class detectCycleUsingKruskal {
    Scanner in = new Scanner(System.in);
    class Edge{
        int src, dest, weight;
    }
    class Set{
        int parent, rank;
    }
    
    int find(Set[] s, int node){
        if(s[node].parent==node) return node;
        return s[node].parent = find(s, s[node].parent);
    }
    
    void Union(Set[] set, int root1, int root2){
        if(set[root1].rank<set[root2].rank) 
            set[root1].parent = root2;
        else if(set[root1].rank>set[root2].rank)
            set[root2].parent = root1;
        else{
            set[root1].parent = root2;
            set[root2].rank++;
        }
    }
    
    Boolean detect(){
        int V, E;
        System.out.print("Enter number of vertices: ");
        V = in.nextInt();
        System.out.print("Enter number of edges: ");
        E = in.nextInt();
        
        System.out.println("Input graph (u <-> v: weight) ");
        Edge[] edges = new Edge[E];
        for(int i=0;i<E;i++){
            edges[i] = new Edge();
            edges[i].src = in.nextInt();
            edges[i].dest = in.nextInt();            
            edges[i].weight = in.nextInt();
        }
        
        Set[] set = new Set[V];
        for(int i=0;i<V;i++){            
            set[i]= new Set();
            set[i].parent = i;
            set[i].rank = 0;
        }
        int e = 0;
        while(e<E){
            Edge nextEdge = edges[e++];
            int root1 = find(set,nextEdge.src);           
            int root2 = find(set,nextEdge.dest);
            if(root1==root2){
                System.out.println("Cycle was found in this graph");
                return true;
            }
            else {
                Union(set,root1,root2);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        detectCycleUsingKruskal obj1 = new detectCycleUsingKruskal();
        if(!obj1.detect())
            System.out.println("No cycle was found in this graph");
    }
}
