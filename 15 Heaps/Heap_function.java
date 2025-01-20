import java.util.*;

public class Heap_function {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {// O(log n)
            // add at last of AL
            arr.add(data);
            int x = arr.size() - 1;// child index
            int par = (x - 1) / 2;// parent index
            // fixing heap
            while (arr.get(x) < arr.get(par)) {
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x - 1) / 2;
            }
        }

        // peek func

        public int peek() {
            return arr.get(0);
        }

        // remove func

        public int remove() {
            int data = arr.get(0);
            // swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);
            // remove last element
            arr.remove(arr.size() - 1);
            // fix heap- heapify
            heapify(0);
            return data;
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;
            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }

        // is empty func
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    // heap sort

    public static void heapSort(int[] arr) {
        // to build max heap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }
        // push largest at end
        for (int i = n - 1; i > 0; i--) {
            // swap first idx to last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }
        if (maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, size);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 3 };
        heapSort(arr);

        // print
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
