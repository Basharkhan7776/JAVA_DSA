public class Search {
    public static boolean searchNumber(int matrix[][],int flag) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]==flag) {
                    System.out.println("At index = "+i+","+j);
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][]={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(searchNumber(matrix, 10));
    }
}
