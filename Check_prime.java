import java.util.*;
public class Check_prime {
    public static Boolean isPrime(int num){
        Boolean ch=true;
        for (int i = 2; i < num; i++) {
            if(num%i==0){ 
                ch=false;
                break;
            }
        }
        return ch;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number = ");
        int n=sc.nextInt();
        if(isPrime(n)==true) System.out.println("Prime");
        else System.out.println("Not Prime");
        sc.close();
    }
}