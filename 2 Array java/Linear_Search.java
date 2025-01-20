import java.util.*;
public class Linear_Search {
    public static int linearSearch(int arr[], int key){
        for (int i = 0; i < arr.length; i++) {
            if(key==arr[i])
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a[]=new int[10];
        System.out.print("Enter Array = ");
        for (int i = 0; i < a.length; i++) {
            a[i]=sc.nextInt();
        }
        System.out.print("Enter number to Search = ");
        int k=sc.nextInt();
        if (linearSearch(a, k)==-1) {
            System.out.println("Not found");
        }
        else{
            System.out.println("Key is found at "+linearSearch(a, k)+" index");
        }
        sc.close();
    }
}
