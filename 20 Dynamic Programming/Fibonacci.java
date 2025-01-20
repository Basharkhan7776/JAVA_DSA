public class Fibonacci {
    public static int fiboMemo(int n, int[] fib) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (fib[n] != 0) {
            return fib[n];
        }
        fib[n] = fiboMemo(n - 1, fib) + fiboMemo(n - 2, fib);
        return fib[n];
    }

    public static int fiboTab(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] fib = new int[n + 1];
        System.out.println(fiboMemo(n, fib));
        System.out.println(fiboTab(n, fib));
    }
}
