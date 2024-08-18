
/*
    Find Union and Intersection of given two arr
 */
import java.util.*;

public class Union_Intersection {
    public static HashSet<Integer> intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (set1.contains(arr2[i])) {
                res.add(arr2[i]);
            }
        }
        return res;
    }

    public static HashSet<Integer> union(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        return set;
    }

    public static void main(String[] args) {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        System.out.println("Union = " + union(arr1, arr2));
        System.out.println("Intersection" + intersection(arr1, arr2));
    }
}
