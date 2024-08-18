import java.util.*;
public class Largest_No_Lin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a[]=new int[5];
        System.out.print("Enter array = ");
        for (int i = 0; i < a.length; i++)
            a[i]=sc.nextInt();
        int lar=a[0];
        for (int i = 0; i < a.length; i++) {
            if (lar<a[i])
                lar=a[i];
        }
        System.out.println("Largest number is "+lar);
        sc.close();
    }
}
