/*
    Count the ways to reach the nth stair.
    the person can jump 1 or 2 stair at a time 
 */
public class CLimbingStairs {
    public static int climbStairRec(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return climbStairRec(n - 1) + climbStairRec(n - 2);
    }

    public static int climbStairMemo(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = climbStairMemo(n - 1, dp) + climbStairMemo(n - 2, dp);
        return dp[n];
    }

    public static int climbStairTab(int n, int[] dp) {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        System.out.println(climbStairTab(n, dp));
    }
}
