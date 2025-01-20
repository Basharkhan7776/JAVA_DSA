public class Opertion {
    public static String decToBin(int n){
        if(n==0)
        return "0";
        StringBuilder bin=new StringBuilder();
        while(n>0){
            int rem=n%2;
            bin.insert(0, rem);
            n/=2;
        }
        return bin.toString();
    }
    public static int getithBit(int n, int i){
        int bitMask=1<<i;
        return (n&bitMask)>>i;
    }
    public static int setithBit(int n,int i){
        int bitMask=1<<i;
        return n|bitMask;
    }
    public static int clearithBit(int n, int i){
        int bitMask=~(1<<i);
        return n & bitMask;
    }
    public static int updateithBit(int n,int i, int bit){
        bit=bit<<i;
        return n|bit;
    }
    public static int clearLastithBit(int n, int i){
        int bitMask=~0<<i;//~0 ------> 11111111 ------> -1
        return n&bitMask;
    }
    public static int clearRangeOfBits(int n,int i, int j){
        int a=~0<<(j+1);
        int b=~(~0<<i);//(1<<i)-1;------> V cn also use this
        int bitMask=a|b;
        return n&bitMask;
    }
    public static void main(String[] args) {//U  can optamized this code :)
        // System.out.println(getithBit(19, 5));
        // System.out.println(setithBit(10, 2));
        // System.out.println(clearithBit(10, 1));
        // System.out.println(updateithBit(10, 1, 1));
        // System.out.println(clearLastithBit(15, 2));
        System.out.println(clearRangeOfBits(10, 2, 4));
    }
}
