/*
 Tiling Problem :- Given 2xn floor and tile size is 2x1 
 count the number of ways to tile in given floor
 (A tile can be place horixontally of vertically)?
 */
public class TilingProblem {
    public static int tilingProblem(int n)//2 x n floor
    {
        if(n==0||n==1)
        return 1;
        return tilingProblem(n-1) + tilingProblem(n-2);// horizontal ways and vertical ways
    }
    public static void main(String[] args) {
        System.out.println(tilingProblem(9));
    }
}