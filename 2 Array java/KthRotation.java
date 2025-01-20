/*
 Kth rotation of array// [1,2,3,4,5] k=2 ------> o/p [4,5,1,2,3]
 */
public class KthRotation {
    public static void rotated(int list[], int k){
        int temp[]=new int[list.length];
        for (int i = 0; i < list.length; i++) {
            temp[(i+k)%list.length]=list[i];
        }
        for (int i = 0; i < temp.length; i++) {
            list[i]=temp[i];
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int k=2;
        rotated(arr, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("|"+arr[i]+"|");
        }
    }
}
