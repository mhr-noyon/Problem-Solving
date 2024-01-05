package bfs;
import java.util.*;

public class topologicalSortUsingBFS {
    static final int N = 100000;
    static Queue<Integer> q = new LinkedList<>();
    static int[] inDeg = new int[N];
    static List<Integer> sortedEl = new ArrayList<>();

    static boolean topologicalSort(List<Integer>[] adjList, int n) {
        for (int i = 1; i <= n; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }
        if (q.isEmpty()) {
            return false;
        }
        while (!q.isEmpty()) {
            int parent = q.poll();
            sortedEl.add(parent);
            for (int val : adjList[parent]) {
                inDeg[val]--;
                if (inDeg[val] == 0) {
                    q.add(val);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("In Graph: ");
        System.out.print("Number of vertix: ");
        int n = in.nextInt();
        System.out.print("Number of edge: ");
        int m = in.nextInt();
        List<Integer>[] adjList = new ArrayList[N];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        System.out.println("Input edges as u -> v format: ");
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adjList[u].add(v);
            inDeg[v]++;
        }
        topologicalSort(adjList, n);
        System.out.print("Sorted Nodes");
        for (int x : sortedEl) {
            System.out.print("--> " + x);
        }
        System.out.println("\n");
    }
}
