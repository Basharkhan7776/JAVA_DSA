/*
Place N Queen in NxN chess board search that no two queens can attack each other
 */
public class NQueens {
    public static void printBoard(char board[][]){
        for (int i = 0; i < board.length; i++) {
            System.out.print("___");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("|"+board[i][j]+"|");
            }
            System.out.println();
        }
    }
    public static boolean isSafe( char board[][],int row ,int col){
        //vertically up
        for (int i = row-1; i >= 0; i--) {
            if(board[i][col]=='Q')
            return false;
        }
        //left up diagonal
        for(int i=row-1, j=col-1;i>=0 && j>=0;i--, j--){
            if(board[i][j]=='Q')
            return false;
        }
        //right up diagonal
        for(int i=row-1, j=col+1;i>=0 && j<board.length;i--, j++){
            if(board[i][j]=='Q')
            return false;
        }
        return true;
    }
    public static void nQueens(char borad [][],int row){
        if(row==borad.length){//base case
            printBoard(borad);
            count++;
            return;
        }
        //loop on columns
        for (int j = 0; j < borad.length; j++) {
            if(isSafe(borad, row, j)){
                borad[row][j]='Q';
                nQueens(borad, row+1);//recursive call
                borad[row][j]='.';//Backtracking step unplacing Q in char array
            }
        }
    }
    static int count=0;//To count number of ways in n queen
    public static void main(String[] args) {
        int n=4;
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        nQueens(board, 0);
        System.out.println("Numbers of ways = "+count);
    }
    
}