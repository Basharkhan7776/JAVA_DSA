public class PairArray {
    public static void pairArray(int arr[]){//Total numbers of pairs is n(n-1)/2----->sum of n-1 number 
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                System.out.print("("+arr[i]+","+arr[j]+"), ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        pairArray(a);
    }
}
