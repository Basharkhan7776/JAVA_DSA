public class InsertionSort {
    public static void insertionSort(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            int curr=arr[i];
            int j=i-1;
            //Find out correct position to insert
            while(j>=0&&arr[j]>curr){
                arr[j+1]=arr[j];
                j--;
            }
            //Insertion
            arr[j+1]=curr;
        }
    }
    public static void main(String[] args) {
        int a[]={5,4,1,3,2};
        insertionSort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print("|"+a[i]+"|");
    }
}
