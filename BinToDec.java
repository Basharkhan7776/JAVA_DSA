import java.util.*;
public class BinToDec {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number in Binary = ");
        int n=sc.nextInt();
        int dec=0, pow=0;
        while (n!=0) {
            dec+=(n%10)*(Math.pow(2,pow));
            pow++;
            n/=10;
        }
        System.out.println(dec);
        sc.close();
    }
}