public class SearchInMatrx {
    public static void searching(int matrix[][],int key) {//Bruteforce method------------>O(n^2)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (key==matrix[i][j]) {
                    System.out.println("Key at "+i+","+j);
                }
            }
        }
    }
    public static void searchingTwo(int matrix[][],int key){//Binery Search in every rows
        for (int i = 0; i < matrix.length; i++) {//Time complexity----------->O(nlogn)
            int start=0,end=matrix[0].length-1,mid;
            while(start<=end){
                mid=(start+end)/2;
                if (matrix[i][mid]==key) {
                    System.out.println("Key at "+i+","+mid);
                    break;
                }
                else if(matrix[i][mid]<key){//right
                    start=mid+1;
                }
                else {//left
                    end=mid-1;
                }
            }
        }
    }
    public static void staircaseSearching(int matrix[][],int key) {//Time complexity---------->O(n+m)
        int i=0, j=matrix[0].length-1;
        while (i<matrix.length&&j>=0) {
            if (matrix[i][j]==key) {
                System.out.println("Key at "+i+","+j);
                return;
            }
            else if(key<matrix[i][j]){
                j--;
            }
            else{
                i++;
            }
        }
        System.out.println("Key not found");
    }
    public static void main(String[] args) {
        int matrix[][]={{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};
        searching(matrix,5);
        searchingTwo(matrix, 5);
        staircaseSearching(matrix, 5);
    }
}
