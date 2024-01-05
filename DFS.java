package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* @author Noyon */
public class DFS {
    static Scanner in = new Scanner(System.in);
    static final int N = 100000;
    static boolean[] visited = new boolean[N];    
    static int[] prev = new int[N];

    public static void main(String[] args) {
        List<Integer>[] adjList = new ArrayList[N];
        System.out.print("Enter number of nodes: ");
        int n = in.nextInt();
        System.out.print("Enter number of edges: ");
        int m = in.nextInt();
        for(int i=0;i<=n;i++){
            adjList[i] = new ArrayList<>();            
        }
        
        System.out.println("Enter edges (u-v): ");
        for(int i=0;i<m;i++){
            int u = in.nextInt();
            int v = in.nextInt();
            adjList[u].add(v);
            adjList[v].add(u);

        }
        dfs(adjList,1);
    }
    static void dfs(List<Integer>[] adjList,int node){
        System.out.println(node+" -> ");
        visited[node] = true;
        for(int child : adjList[node]){
            if(!visited[child]){
                prev[child] = node;
                dfs(adjList,child);
            }
            else if(visited[child] && prev[node]!=child){
                System.out.println("Cycle detected!");                     
            }
        }
    }

}
