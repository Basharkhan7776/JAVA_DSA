public class PrintNterms {
    public static void nDecOrder(int n) {
        if(n==1){
            System.out.print(1);
            return;
        }

        System.out.print(n+", ");
        nDecOrder(n-1);
    }
    public static void nIncOrder(int n){
        if(n==1){
            System.out.print(1);
            return;
        }

        nIncOrder(n-1);
        System.out.print(", "+n);

    }
    public static void main(String[] args) {
        int n=9;
        nDecOrder(n);
        System.out.println();
        nIncOrder(n);
    }
}
