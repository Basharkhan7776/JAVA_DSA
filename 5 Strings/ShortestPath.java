/*Given route contaion four direction(N S E W). Find the shotest distance between origin and destiny */
public class ShortestPath {
 public static float shortestPath(String der) {
    int x=0,y=0;
    for (int i = 0; i < der.length(); i++) {
        char ch=der.charAt(i);
        if(ch=='N')
        y++;
        else if(ch=='S')
        y--;
        else if(ch=='E')
        x++;
        else if(ch=='W')
        x--;
    }
    return (float)Math.sqrt(x*x+y*y);
}
public static void main(String[] args) {
 String str="WNEENESENNN";
 System.out.println(shortestPath(str));
}
}
