
/*
    Given two arrays A and B. Pair each element of Array A
    to an element in array B, such that sum of abs diff
    of all the pairs is minimum
    A={1,2,3}
    B={2,1,3}
    Ans=0
 */
import java.util.*;

public class Min_Abs_Diff {
    public static int minAbsDiff(int[] A, int[] B) {
        Arrays.sort(A);// 1,2,3
        Arrays.sort(B);// 1,2,3
        // Sorted Linearly pairs are minimum
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += Math.abs(A[i] - B[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3 };
        int[] B = { 2, 1, 3 };
        System.out.println(minAbsDiff(A, B));
    }
}
