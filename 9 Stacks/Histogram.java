/*
    Given an Array of integer which representing the 
    height of histo width one return maximum rectangle area
    h={2,1,5,6,2,3}-----> area=10
 */
import java.util.Stack;

public class Histogram {
    public static void maxArea(int[] arr) {
        int maxArea = 0;
        int[] nsr = new int[arr.length];
        int[] nsl = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        // Calculate nsr (next smaller element to the right)
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            nsr[i] = s.isEmpty() ? arr.length : s.peek();
            s.push(i);
        }

        // Clear the stack for reusing it
        s.clear();

        // Calculate nsl (next smaller element to the left)
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            nsl[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        // Calculate the maximum area
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println(maxArea);
    }

    public static void main(String[] args) {
        int[] height = {2, 1, 5, 6, 2, 3};
        maxArea(height);
    }
}
