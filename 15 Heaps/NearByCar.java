/*
    Find out the number of k nearby cars if a 
    person is on origin where cars has x and
     y coordinates
 */
import java.util.*;

public class NearByCar {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;

        public Point(int x, int y, int distSq) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String[] args) {
        int pt[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pt.length; i++) {
            int distSq = pt[i][0] * pt[i][0] + pt[i][1] * pt[i][1];
            pq.add(new Point(pt[i][0], pt[i][1], distSq));
        }
        // nearest k cars
        for (int i = 0; i < k; i++) {
            Point p = pq.poll();
            System.out.println(p.x + " " + p.y);
        }
    }
}
