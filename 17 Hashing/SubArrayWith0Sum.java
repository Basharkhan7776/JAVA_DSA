
/*
    Find out the no of element which is the 
    largest subarray in given array who's sum is zero.
 */
import java.util.*;

public class SubArrayWith0Sum {//O(n)
    public static int subArray(int[] arr) {// approch = sum[j]=sum[i]
        if (arr.length == 1)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();// (Sum , Index)
        int sum = 0;
        int len = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum)) {
                len = Math.max(len, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(subArray(arr));
    }
}
