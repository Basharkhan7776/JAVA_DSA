
public class Fibonachhi {
    public static int fibonachi(int n){//time complexity O(2^n)    && Space complexity O(n)
        if (n==1)
            return n;
        if(n==0)
            return n;
        System.out.print(n+", ");
        int temp=fibonachi(n-1)+fibonachi(n-2);
        return temp;
    }
    public static void main(String[] args) {
        System.out.print(fibonachi(25));
    }
}