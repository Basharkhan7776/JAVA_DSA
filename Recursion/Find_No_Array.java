/*
 Finding Number in an Array
 */
public class Find_No_Array {
    public static int firstOccur(int arr[],int i,int key){
        if (i==arr.length-1) {
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOccur(arr, i+1, key);
    }
    public static int lastOccur(int arr[],int i,int key){
        if (arr.length==i) {
            return -1;
        }
        int isFound=lastOccur(arr, i+1, key);
        if(isFound==-1&&arr[i]==key){
            return i;
        }
        return isFound;
    }
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,3,3};
        System.out.println(firstOccur(a, 0, 3));
        System.out.println(lastOccur(a, 0, 3));
    }
}
