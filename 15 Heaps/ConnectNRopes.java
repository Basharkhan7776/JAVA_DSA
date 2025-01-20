
/*
    Given N rope of different lengths, to connect this ropes
    into one rope with minimum cost to connect two ropes is equal
    to the sum of their lenghts
 */
import java.util.*;

public class ConnectNRopes {
    public static int connectRopes(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min + min2);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 3, 4, 6 };
        System.out.println(connectRopes(arr));
    }
}
