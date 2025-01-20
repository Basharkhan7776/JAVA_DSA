
/*
    You are given n pairs of number. In every pair,
    the 1st number is always smaller than the 2nd.
    A pair(c,d) can come after pair (a,b) if b<c.
    Find the longest chain which can be formed 
    from a given set of pairs.
 */
import java.util.*;

public class Max_L_chainPair {
    public static int maxLengthChainOfPair(int[][] pairs) {
        // sorting on bases of 2nd row
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        // counting
        int count = 1;
        int p2 = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > p2) {
                count += 1;
                p2 = pairs[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] pairs = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        int count = maxLengthChainOfPair(pairs);
        System.out.println(count);
    }
}
