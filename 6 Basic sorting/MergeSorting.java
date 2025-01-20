public class MergeSorting {
    public static void merge(int[] arr, int l, int r, int mid) {
        int leftLength = mid - l + 1;
        int rightLength = r - mid;
    
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];
    
        for (int i = 0; i < leftLength; i++)
            left[i] = arr[l + i];
        for (int j = 0; j < rightLength; j++)
            right[j] = arr[mid + 1 + j];
    
        int i = 0, j = 0, k = l;
    
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftLength) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < rightLength) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    
    public static void mergeSort(int[] arr, int l, int r){
        if(l>=r)
            return;
        int mid=l+(r-l)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, r, mid);
    }
    public static void main(String[] args) {
        int[] arr={2,3,6,4,8,1};
        mergeSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("|"+arr[i]+"|");
        }
    }
}
