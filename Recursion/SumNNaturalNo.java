public class SumNNaturalNo {
    public static int sumNo(int n){
        if(n==1)
        return 1;
        return n+sumNo(n-1);
    }
    public static void main(String[] args) {
        System.out.println(sumNo(6));
    }
}
