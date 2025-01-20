/*
    We are given an infinite supply of currency
    {1,2,5,10,20,50,100,500,2000}. Find Min number 
    of Coins/Notes to make change for a value V.
    V=121 -> 3(100+20+1)
    V=590 -> 4(500+50+20+20)
 */

import java.util.ArrayList;

public class Indian_Coins {

    public static int noOfAmount(int v) {// O(n)
        int[] curr = { 2000, 500, 100, 50, 20, 10, 5, 2, 1 };
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        int i = 0;
        while (v != 0) {
            if (curr[i] <= v) {
                count++;
                list.add(curr[i]);
                v -= curr[i];
            } else {
                i++;
            }
        }
        System.out.println("Off's = " + list);
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Number of Coins/Money = " + noOfAmount(590));
    }
}
