/* Printing spiral pattern number in given 2d array
| 1 2 3 4 |
| 5 6 7 8 |-----------> 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
| 9 10 11 12 |
| 13 14 15 16 |
*/
public class PrintSpiral2d {
    public static void spiralPrintMatrix(int matrix[][]) {
        int startRow = 0;
        int startcolumn = 0;
        int endRow = matrix.length - 1;// rows
        int endColumn = matrix[0].length - 1;// columns
        while (startRow <= endRow && startcolumn <= endColumn) {
            // top
            for (int i = startcolumn; i <= endColumn; i++) {
                System.out.print(matrix[startcolumn][i] + ",");
            }
            // right
            for (int i = startcolumn + 1; i <= endColumn; i++) {
                System.out.print(matrix[i][endRow] + ",");
            }
            // bottom
            for (int i = endRow - 1; i >= startRow; i--) {
                System.out.print(matrix[endColumn][i] + ",");
            }
            // left
            for (int i = endColumn - 1; i >= startcolumn + 1; i--) {
                System.out.print(matrix[i][startcolumn] + ",");
            }
            startRow++;
            startcolumn++;
            endRow--;
            endColumn--;
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralPrintMatrix(matrix);
    }

}
