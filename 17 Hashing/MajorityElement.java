
/*
    Given an arr of int size n, find all element
    which appears more than (n/3) times
 */
import java.util.*;

public class MajorityElement {
    public static ArrayList<Integer> majorityElement(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        int flag = arr.length / 3;
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        for (Integer key : hm.keySet()) {
            if (hm.get(key) > flag) {
                res.add(key);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        System.out.println(majorityElement(arr));
    }
}
