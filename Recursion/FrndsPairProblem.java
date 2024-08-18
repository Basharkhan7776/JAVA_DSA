/**
Given n friends, each one can remain single or can be paires upwith some other
friend. Each friend can be paried only once. Find out the total number of ways
in which friends can remain single or can be paired up.
 */
public class FrndsPairProblem {
    public static int friendPairinng(int n){
        if(n==1||n==2)
        return n;
        return friendPairinng(n-1)+(n-1)*friendPairinng(n-2);// Single ways + pairing ways 
    }
    public static void main(String[] args) {
        System.out.println(friendPairinng(4));
    }
}