
public class BubbleSorting 
{
    public static void bubbleSorting(int arr[]){
        for(int i=0;i<arr.length;i++){//Sorting
		    for(int j=0;j<arr.length-i-1;j++){//loop till end of array and leaving last itrate loop
			    if(arr[j]>arr[j+1]){//Worst case O(n^2) tc and best case is O(n^2) tc
				    int temp=arr[j];
				    arr[j]=arr[j+1];
				    arr[j+1]=temp;
			    }
		    }
	    }
    }
    public static void bubbleSortingOptomized(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            boolean flag=false;
            for (int j = 0; j < arr.length-i-1; j++) {//Worst case O(n^2) tc and best case is O(n) tc
                if(arr[j]>arr[j+1]){
				    int temp=arr[j];
				    arr[j]=arr[j+1];
				    arr[j+1]=temp;
                    flag=true;
			    }
            }
            if(flag==false)
            break;
        }
    }
    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        // bubbleSorting(a);
        bubbleSortingOptomized(a);
        for (int i = 0; i < a.length; i++)
            System.out.print("|"+a[i]+"|");
    }
}