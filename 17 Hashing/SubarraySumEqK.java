
/*
    Count no of sub array in given 
    array who's sum is equal to K
    eg;arr={1,2,3} k=3
    ans=2
 */
import java.util.*;

public class SubarraySumEqK {
    public static int subarraySum(int[] arr, int k) {// approch -> sum(j)-sum(i)=k
        HashMap<Integer, Integer> map = new HashMap<>();// (sum,count)
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0));
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 2, -2, -20, 10 };
        int k = -10;
        System.out.println(subarraySum(arr, k));
    }
}
