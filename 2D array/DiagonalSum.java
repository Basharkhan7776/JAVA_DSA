/*
Funtion to print secondry and primery diagonal sum
| 1 2 3 4 |
| 5 6 7 8 |-----------> sec diagonal sum=34 & pri diagonal sum=34
| 9 10 11 12 |
| 13 14 15 16 |
 */
public class DiagonalSum {
    public static void diagonalSum(int matrix[][]) {
        int pSum=0, sSum=0;
        for (int i = 0; i < matrix.length; i++) {//---------->O(n^2)
            for (int j = 0; j < matrix.length; j++) {
                if (i==j)
                pSum+=matrix[i][j];
                if (i+j==matrix.length-1)
                sSum+=matrix[i][j];

            }
        }
        System.out.println(pSum+", "+sSum);
    }
    public static void diagonalSumTwo(int matrix[][]) {
        int pSum=0, sSum=0, n=matrix.length;
        for (int i = 0; i < n; i++) {//---------->O(n)
            pSum+=matrix[i][i];
            sSum+=matrix[i][n-i-1];
        }
        System.out.println(pSum+", "+sSum);
    }
    public static void main(String[] args) {
        int matrix[][]={{4,9,3},
                        {4,5,4},
                        {0,11,9}};
        diagonalSum(matrix);
        diagonalSumTwo(matrix);
    }
}
