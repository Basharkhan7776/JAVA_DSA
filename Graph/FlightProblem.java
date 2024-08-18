
/*  Cheapest Flight within K stops
    Given wt graphs of flight routes find out the path from src 
    to dest with minimum cost and at most k stops
*/
import java.util.*;
import java.util.LinkedList;

public class FlightProblem {
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

    static class Stops {
        int v;
        int cost;
        int stop;

        public Stops(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stop = s;
        }

    }

    public static void createGraph(int[][] flight, ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }

    public static int cheapestFlight(ArrayList<Edge>[] graph, int src, int dest, int k) {
        int[] cost = new int[graph.length];
        // assign infinity dist to all nodes
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                cost[i] = Integer.MAX_VALUE;
            }
        }
        cost[src] = 0;
        Queue<Stops> q = new LinkedList<>();
        q.add(new Stops(src, 0, 0));
        while (!q.isEmpty()) {
            Stops curr = q.remove();
            if (curr.stop > k) {
                break;
            }
            // updation for ngbr
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if (curr.cost + wt < cost[v] && curr.stop <= k) {
                    cost[v] = curr.cost + wt;
                    q.add(new Stops(v, cost[v], curr.stop + 1));
                }
            }
        }
        if (cost[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return cost[dest];
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flight = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dst = 3, k = 1;
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flight, graph);
        System.out.println(cheapestFlight(graph, src, dst, k));
    }
}
