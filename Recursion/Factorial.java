
public class Factorial {
    public static int factorial(int n) {//Time complexity O(n) && Space complexity o(n)--->because
        if(n==1)
        return 1;
        return n*factorial(n-1);
    }
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}