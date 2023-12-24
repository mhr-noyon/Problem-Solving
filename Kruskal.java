package kruskal;
import java.util.*;
/* @author Noyon */

public class Kruskal {
    static Scanner in = new Scanner(System.in);
    class Edge implements Comparable<Edge>{
        int u, v, w;
        @Override
        public int compareTo(Edge cmpEdge) {
            return this.w - cmpEdge.w;
        }
    };
    
    class subset{
        int parent, rank;
    };
    
    static int find(subset[] subsets,int x){
        if(subsets[x].parent==x){
            return subsets[x].parent;
        }
        return subsets[x].parent = find(subsets, subsets[x].parent);
    }
    static void union(subset[] subsets,int root1, int root2){
        if(subsets[root1].rank<subsets[root2].rank)
            subsets[root1].parent = root2;
        else if(subsets[root1].rank>subsets[root2].rank)
            subsets[root2].parent = root1;
        else{
            subsets[root1].parent = root2;
            subsets[root2].rank++;
        }     
    }
    
    void kruskals( int N, int E){
        System.out.println("Insert graph (u - v - w): ");
        Edge[] edges = new Edge[E];
        
        for(int i = 0;i<E;i++){
            edges[i] = new Edge();
            edges[i].u = in.nextInt();            
            edges[i].v = in.nextInt();
            edges[i].w = in.nextInt();
        }
        Arrays.sort(edges);
        
        //print edges
//        System.out.println("Printing sorted edges: ");
//        for(int j = 0;j<E;j++){
//            System.out.println(edges[j].u+" "+edges[j].v+" "+edges[j].w);
//        }
        
        subset[] subsets = new subset[N];        
        Edge[] minSpan = new Edge[N];
        for(int i=0;i<N;i++){
            subsets[i] = new subset();    
            subsets[i].parent = i;
            subsets[i].rank = 0;
            minSpan[i] = new Edge();
        }
        
        int e = 0,i=0;
        while(e<N-1){
            Edge nextEdge = edges[i++];
            int x = find(subsets,nextEdge.u);
            int y = find(subsets,nextEdge.v);
            if(x!=y){
                minSpan[e++] = nextEdge;
                union(subsets,x,y);
            }
            else{
                System.out.println("There is a cycle.");
            }
        }
        //Printing MST
        System.out.println("Minimum spanning tree: ");
        int cost = 0;
        for(int ind=0;ind<e;ind++){
            System.out.println(minSpan[ind].u+" "+minSpan[ind].v
            +" "+minSpan[ind].w);
            cost+= minSpan[ind].w;
        }
        System.out.println("Total cost: "+cost);
    }
    
    
    public static void main(String[] args) {
        System.out.print("Number of nodes: ");
        int n = in.nextInt();        
        System.out.print("Number of edges: ");
        int e = in.nextInt(); 
        
        Kruskal obj1 =  new Kruskal();
        obj1.kruskals(n,e);
    }

}
