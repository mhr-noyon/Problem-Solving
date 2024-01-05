package bfs;
import java.util.*;
public class BFS {
    static final int N = 100000;
    static boolean[] visited = new boolean[N];
    static Queue<Integer> q = new LinkedList<>();
    static int[] prev = new int[N];

    static boolean detectCycle(List<Integer>[] adjList, int n) {
        q.add(1);
        visited[1] = true;
        prev[1] = -1;
        while (!q.isEmpty()) {
//            Queue state print:
//            System.out.print("Queue state: ");
//            for(int qVal: q){
//                System.out.print(qVal+" ");
//            }
//            System.out.println("");
            
            int parent = q.poll();
            
            for (int val : adjList[parent]) {
                //For cycle detection: 
                if (visited[val] && val != prev[parent]) {
                    return true;
                }
                if (!visited[val]) {
                    q.add(val);
                    visited[val] = true;
                    prev[val] = parent;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("In Graph:\n");
        System.out.print("Number of vertix: ");
        int n = in.nextInt();
        System.out.print("Number of edge: ");
        int m = in.nextInt();
        List<Integer>[] adjList = new ArrayList[N];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        System.out.println("Input edges as u <-> v format: ");
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adjList[u].add(v);
            adjList[v].add(u);
        }
        if (detectCycle(adjList, n)) {
            System.out.println("The graph has cycle.");
        } else {
            System.out.println("The graph has no cycle.");
        }
    }
}
