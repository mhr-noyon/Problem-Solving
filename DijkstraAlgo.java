package dijkstraalgo;
import java.util.*;

public class DijkstraAlgo {
    static final int N = 10005;
    static final int INF = 1000000010; 
    static List<Boolean> visited = new ArrayList<>(N);
    static List<Integer> dist = new ArrayList<>(N);    
    static int prev[] = new int[N];

    static List<List<Pair>> adjList = new ArrayList<>(N);

    static class Pair {
        int first, second; //first -> weight, second -> node
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
//    static int comp (int a, int b){
//        return a-b;
//    }
    static void dijkstra(int source) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));             
//            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> comp(a.first, b.first));        

        Arrays.fill(dist.toArray(), INF);
        dist.set(source, 0);
//        for(int i = 0; i<N;i++){
//            prev[i] = -1;
//        }
        pq.add(new Pair(dist.get(source), source));

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int u = top.second;
            visited.set(u, true);

            for (Pair val : adjList.get(u)) {
                int v = val.first;
                int w = val.second;

                if (!visited.get(v)) {
                    if (dist.get(v) > dist.get(u) + w) {
                        dist.set(v, dist.get(u) + w);
                        pq.add(new Pair(dist.get(v), v));
                        prev[v] = u;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices (n): ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of edges (m): ");
        int m = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            visited.add(false);
            dist.add(INF);
            adjList.add(new ArrayList<>());
        }

        System.out.print("Enter EDGES (u-v-w): ");
        // Read and populate the adjacency list
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            adjList.get(u).add(new Pair(v, w));
            adjList.get(v).add(new Pair(u, w));
        }

        dijkstra(1); 

        for (int i = 1; i <= n; i++) {
            System.out.println("Distance From node (1) to (" + i + "): " + dist.get(i));
        }
    }
}