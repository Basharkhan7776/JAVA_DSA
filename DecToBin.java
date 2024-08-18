import java.util.*;
public class DecToBin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number in Decimal = ");
        int n=sc.nextInt();
        int bin=0, pow=0;
        while (n!=0) {
            bin+=(n%2)*Math.pow(10,pow);
            n/=2;
            pow++;
        }
        System.out.println(bin);
        sc.close();
    }
}
