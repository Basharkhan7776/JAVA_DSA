
/*
   Strongly Connected Components - Edge from where
    all other edge can be reached done by kosaraju algo
 */
import java.util.*;

public class kosarajuSSC {
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

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));
        graph[0].add(new Edge(1, 0, 1));
        graph[0].add(new Edge(2, 1, 1));
        graph[0].add(new Edge(3, 4, 1));
    }

    public static void kosaraju(ArrayList<Edge> graph[], int V) {
        // step 1 topsort
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topsort(graph, i, vis, s);
            }
        }
        // step 2 transpose of graph
        ArrayList<Edge> trans[] = new ArrayList[V];
        for (int i = 0; i < trans.length; i++) {
            vis[i] = false;
            trans[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);// e.src -> e.dest
                trans[e.dest].add(new Edge(e.dest, e.src, 1));// reverse
            }
        }
        // step 3 call dfs for stack pop element
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                dfs(trans, curr, vis);
                System.out.println();
            }
        }
    }

    public static void topsort(ArrayList<Edge> graph[], int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[i].get(i);
            if (!vis[e.dest]) {
                topsort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[i].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V); 
    }
}
