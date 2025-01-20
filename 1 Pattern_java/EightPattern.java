public class EightPattern {
    public static void main(String[] args) {
        int n=6;
        for (int i=1;i<=n;i++) 
        {
            for (int j = 1; j <=n+1; j++) 
            {
                if(j==1||i==1||i==n||j==n+1)
                System.out.print("* ");
                else
                System.out.print("  ");
            }
            
            System.out.println();
        }
        for (int i=1;i<=n-1;i++) 
        {
            for (int j = 1; j <=n+1; j++) 
            {
                if(j==1||i==n-1||j==n+1)
                System.out.print("* ");
                else
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
