public class Count1BitNo {
    public static int countHiBit(int n){
        int count=0;
        while (n>0) {
            if ((n&1)==1)
                count++;
            n=n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countHiBit(10));
    }
}
