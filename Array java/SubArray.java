public class SubArray {
    public static void printSubarray(int arr[]){//Like pair question start from one to end other pair
        int d=0;
        for (int i = 0; i < arr.length; i++) {//start iteration 
            for (int j = i; j < arr.length ; j++) {//End iteration
                for(int k=i;k<=j;k++){
                    System.out.print("|"+arr[k]+"|");
                }
                d++;
                System.out.println();
            }
            System.out.println("\n");
        }
        System.out.println("Number of subarrays = "+d);//Total number of subarrays =n(n+1)/2
    }
    public static void main(String[] args) {
        int a[]={1,3,4,5,7};
        printSubarray(a);
    }
}
