public class Floyds_triangle {
    public static void main(String[] args) {
        int n=5;
        int a=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((a++)+" ");
            }
            System.out.println();
        }
    }
}
