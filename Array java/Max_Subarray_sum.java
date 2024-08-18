public class Max_Subarray_sum {
    public static int maxSubarraySumBR(int arr[]){//Brute Force algorithm
        int maxSum=Integer.MIN_VALUE;//Time complexity -----> O(n^3)
        for (int i = 0; i < arr.length; i++) { 
            for (int j = i; j < arr.length ; j++) {
                int sum=0;
                for(int k=i;k<=j;k++)
                    sum+=arr[k];
                if(maxSum<sum)
                    maxSum=sum;
            }
        }
        return maxSum;
    }
    public static int maxSubarraySumPS(int arr[]){//Prefix sum algorithm
        int maxSum=Integer.MIN_VALUE;//Time complexity -----> O(n^2+n)
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i]=prefix[i-1]+arr[i];
        }
        for (int i = 0; i < arr.length; i++) { //Start
            for (int j = i; j < arr.length ; j++) {//End 
                int sum=i==0?prefix[j]:prefix[j]-prefix[i-1];
                if(maxSum<sum)
                    maxSum=sum;
            }
        }
        return maxSum;
    }
    public static int maxSubarraySumKD(int arr[]){//Kadanes algorithm
        int ms=Integer.MIN_VALUE;
        int cs=0;
        for (int i = 0; i < arr.length; i++) {//Time complexity -----> O(n)
            cs+=arr[i];
            if(cs<0){
                cs=0;
            }
            ms=Math.max(ms,cs);
        }
        return ms;
    }
    public static void main(String[] args) {
        int a[]={-2,-3,4,-1,-2,1,5,-3};
        System.out.println(maxSubarraySumBR(a));
        System.out.println(maxSubarraySumPS(a));
        System.out.println(maxSubarraySumKD(a));
    }
}
