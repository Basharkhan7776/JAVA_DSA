import java.util.Scanner;

public class Binary_Search {
    public static int binarySearch(int arr[], int key) {// tc ---------> O(logn)
        int start = 0, end = arr.length - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {// right
                start = mid + 1;
            } else {// left
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int array[] = new int[10];
        System.out.print("Enter Array = ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        System.out.print("Enter number to Search = ");
        int number = sc.nextInt();
        if (binarySearch(array, number) == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println("Number is at " + binarySearch(array, number) + " index");
        }
        sc.close();
    }
}
