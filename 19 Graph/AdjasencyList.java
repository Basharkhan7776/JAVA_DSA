
//Implement uni directional graphs using adjacency list 
import java.util.*;
import java.util.LinkedList;

import javafx.scene.paint.Stop;

public class AdjasencyList {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Implimenting BFS in disconnected graphs
    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }

    // Implimenting BFS = Breath First search
    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) {// O(V+E)
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + ", ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    // Implimenting DFS in disconnected graphs
    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsUtil(graph, i, vis);
            }
        }
    }

    // Implimenting DFS = Depth First Search
    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    // Has path -> tell if path b/w src(given) and dest(given) exists
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {// O(V+E)
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    // Cycle Detection using DFS in undirected graphs
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, vis, i, -1))
                    return true;
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest] && isCycleUtil(graph, vis, e.dest, curr)) {
                return true;
            } else if (vis[e.dest] && e.dest != par) {
                return true;
            }
        }
        return false;
    }

    // Cycle Detection using DFS in Directed graphs
    public static boolean isCycleDirected(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] s = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleDirectedUtil(graph, vis, i, s))
                    return true;
            }
        }
        return false;
    }

    public static boolean isCycleDirectedUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, boolean[] s) {
        vis[curr] = true;
        s[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (s[e.dest]) {// Condition of Cycle
                return true;
            }
            if (!vis[e.dest] && isCycleDirectedUtil(graph, vis, e.dest, s)) {
                return true;
            }
        }
        s[curr] = false;
        return false;
    }

    // Topological Sorting -> only for DAG
    public static void topologicalSorting(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topologicalSortingUtil(graph, vis, i, st);
            }
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void topologicalSortingUtil(ArrayList<Edge>[] graph, boolean[] vis, int cur, Stack<Integer> st) {
        vis[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);
            if (!vis[e.dest]) {
                topologicalSortingUtil(graph, vis, e.dest, st);
            }
        }
        st.push(cur);
    }

    // Topological sort using BFS(kahn's algo)
    public static void topSort(ArrayList<Edge>[] graph) {
        int[] indeg = new int[graph.length];
        calIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void calIndeg(ArrayList<Edge>[] graph, int[] indeg) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    // Print all path from source to target using dfs
    public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path) {// O(e^n)
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path + src);
        }
    }

    // shortest path from source to all vertices(weight) using Dijkstra's Algo
    public static void dijkstra(ArrayList<Edge>[] graph, int src) {// O(V+ElogV)
        int[] dist = new int[graph.length];// dist to i
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;// +infinty
            }
        }
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {// ngbr's
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[u] + wt < dist[v]) {// update dist of src to v
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    static class Pair implements Comparable<Pair> {// for pair of path-dis of node
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    // shortest path from source to all vertices(weight) using bellman ford Algo
    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {// O(V+E) with -ve wt not for -ve wt cycle
        int[] dist = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[u] != Integer.MAX_VALUE && (dist[u] + wt < dist[v])) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    // Prim's Algorithm to find Minimum spanning tree(MST)
    public static void prims(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<vCostPair> pq = new PriorityQueue<>();
        pq.add(new vCostPair(0, 0));
        int finalCost = 0;
        while (!pq.isEmpty()) {
            vCostPair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new vCostPair(e.dest, e.wt));
                }
            }
        }
        System.out.println(finalCost);
    }

    static class vCostPair implements Comparable<vCostPair> {
        int v;
        int cost;

        public vCostPair(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(vCostPair p2) {
            return this.cost - p2.cost;// acending
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];// null -> empty array List
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();// initalizition on array list
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
        prims(graph);
    }
}
