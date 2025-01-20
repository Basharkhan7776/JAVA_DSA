/*
 Finding Power of Number with recursion?!
 */
public class PowerOfNo {
    public static int powerNumber(int n,int p){//Time complexity O(n)
        if(p==0)
        return 1;
        return n*powerNumber(n, p-1);
    } 
    public static int powerNumberO(int n,int p){//Time complexity O(log2(n))
        if (p==0) {
            return 1;
        }
        int halfPow=powerNumberO(n, p/2);//Reusablity of this var multiple time to one time compute
        if(p%2!=0){ 
            return n*halfPow*halfPow;
        }
        return halfPow*halfPow;

    }
    public static void main(String[] args) {
        System.out.println(powerNumber(2, 3));
        System.out.println(powerNumberO(2, 3));
    }
}