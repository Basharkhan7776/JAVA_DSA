public class CountingSort {
    public static void countingSort(int arr[]) {
            int maxNo=Integer.MIN_VALUE;//assigning min value

            for (int i = 0; i < arr.length; i++)
                maxNo=Math.max(maxNo,arr[i]);//finding max value

            int count[]=new int[maxNo+1];//counting freq of arr in it and index repre--->number(arr)
            //counting frquency
            for (int i = 0; i < arr.length; i++)
                count[arr[i]]++;
                
            //sorting
            int j=0;//triversal for arr
            for (int i = 0; i < count.length; i++) {//triversal for count
                while (count[i]>0) {
                    arr[j]=i;
                    j++;
                    count[i]--;//dec counting in count
                }
            }
    }
    public static void main(String[] args) {
        int a[]={5,4,1,3,2};
        countingSort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print("|"+a[i]+"|");
    }
}
