public class SelectionSort {
    public static void selectionSort(int arr[]){
        for (int i = 0; i < arr.length-2; i++) {
            int minPos=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minPos]>arr[j])
                    minPos=j;
            }
            //Swap
            int temp=arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
    }
    public static void main(String[] args) {
        int a[]={5,4,1,3,2};
        selectionSort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print("|"+a[i]+"|");
    }
}
