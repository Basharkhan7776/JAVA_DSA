/*
    Given the  value and weight of N item put this 
    item in knapsack of Capacity W to get the max
    total value in knapsack
    value={ 60, 100, 120 };
    weight={ 10, 20, 30 };
    cap=50;
    output=240
 */

import java.util.Arrays;
import java.util.Comparator;

public class Fractional_KnapSack {
    public static int knapSack(int[] weight, int[] value, int capacity) {
        int amt = 0;
        // value/weight and stored in 2d array
        double[][] sack = new double[value.length][3];
        for (int i = 0; i < value.length; i++) {
            sack[i][0] = value[i];
            sack[i][1] = weight[i];
            sack[i][2] = (double) (value[i] / weight[i]);
        }
        // sorting of v/w
        Arrays.sort(sack, Comparator.comparingDouble(o -> o[2]));
        // Picking largest v/w
        for (int i = value.length - 1; i >= 0; i--) {
            if (capacity >= sack[i][1])
                amt += sack[i][0];
            else
                amt += (capacity * sack[i][2]);
            capacity -= sack[i][1];
        }
        return amt;
    }

    public static void main(String[] args) {
        int[] value = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };
        int cap = 50;
        System.out.println(knapSack(weight, value, cap));
    }
}