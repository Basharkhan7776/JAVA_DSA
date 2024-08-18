import java.util.*;

public class Reverse_Array {
    public static void reverseArray(int arr[]){
        for (int i = 0; i < arr.length/2; i++) {//Time complexity=n/1, where n ---> size of array
            int temp=arr[i];//Space complexity=1
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int array[]=new int[5];
        System.out.print("Enter Array = ");
        for (int i = 0; i < array.length; i++) {
            array[i]=sc.nextInt();
        }
        reverseArray(array);
        System.out.print("Reverse Array = ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        sc.close();
    }
}
