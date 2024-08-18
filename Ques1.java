class Ques1 {
    public static void sortColors(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int zeros = 0, ones = 0, twos = 0, len = arr.length;
        // count 0,1,2
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                zeros++;
            } else if (arr[i] == 1) {
                ones++;
            } else if (arr[i] == 2) {
                twos++;
            }
        }
        // put in array
        int i = 0;
        while (i < len) {
            if (zeros != 0 && ones != 0 && twos != 0) {
                arr[i++] = 0;
                zeros--;
            } else if (zeros == 0 && ones != 0 && twos != 0) {
                arr[i++] = 1;
                ones--;
            } else if (zeros == 0 && ones == 0 && twos != 0) {
                arr[i++] = 2;
                twos--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0 };
        sortColors(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}