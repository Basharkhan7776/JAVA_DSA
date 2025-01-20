/*
Find the number of ways to reach from 0,0 to n-1,m-1 of grid nxm
Allowed moves are right and down
 */
public class GridWays {
    public static int noWays(int grid[][], int row, int column){//tc------> O(2^nxm)
        if(row==grid.length-1&&column==grid[0].length-1){//condition of last cell
            return 1;
        }
        else if(row==grid.length||column==grid[0].length){//condition of boundry cross 
            return 0;
        }
        return noWays(grid, row+1, column) + noWays(grid, row, column+1);
    }
    public static int gridWays(int n, int m){//tc---------> O(n+m)
        return(factorial(m-1+n-1)/(factorial(n-1)*factorial(m-1)));//simple P and C formula 
    }
    public static int factorial(int n) {
        if(n==1)
        return 1;
        return n*factorial(n-1);
    } 
    public static void main(String[] args) {
        int n=5; 
        int m=4;
        int matrix[][]=new int[n][m];
        System.out.println(noWays(matrix, 0, 0));
        System.out.println(gridWays(n, m));
    }
}