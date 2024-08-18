
/*
    Given 2d matrix of 0(civilians) and 1(soldiers),
    find out Kth weakest row in matrix if no of 
    1 are same then postion of row is in priority(i<j then i is taken)
    matrix[][]=|1000|
               |1111| ------> k=2 ----> ans = row 0 and row 2
               |1000|
               |1000|
 */
import java.util.*;

public class WeakestSolder {
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = { { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 } };
        int k = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[i].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }
        for (int i = 0; i < k; i++) {
            Row r = pq.poll();
            System.out.println("Weakest row is " + r.idx);
        }
    }
}
