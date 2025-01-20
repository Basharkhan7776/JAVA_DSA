
/*
    given the item value and wt, you have choice
     either add or not add this item in knapsack
    find maximum val of items that stored in knapsack
    for given cap of knapsack.
 */
import java.util.*;

public class Knapsack01 {
    public static int knapSackRec(int[] val, int[] wt, int W, int n) {// O(2^n)
        if (W == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {// valid
            // include
            int ans1 = val[n - 1] + knapSackRec(val, wt, W - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapSackRec(val, wt, W, n - 1);
            return Math.max(ans1, ans2);
        } else {// not valid
            return knapSackRec(val, wt, W, n - 1);
        }
    }

    public static int knapSackMemo(int[] val, int[] wt, int W, int n, int dp[][]) {// O(n*W)
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) {// valid
            // include
            int ans1 = val[n - 1] + knapSackMemo(val, wt, W - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = knapSackMemo(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {// not valid
            dp[n][W] = knapSackMemo(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    public static int knapsackTab(int[] val, int[] wt, int W, int n, int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];// ith item value
                int w = wt[i - 1];// ith item weight
                if (w <= j) {// valid
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {// invalid
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackTab(val, wt, W, val.length, dp));
    }
}
