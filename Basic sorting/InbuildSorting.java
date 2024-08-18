import java.util.Arrays;
public class InbuildSorting {
    public static void main(String[] args) {
        int a[]={5,4,1,3,2};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print("|"+a[i]+"|");
    }
}
