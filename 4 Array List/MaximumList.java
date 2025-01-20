/*
  Find maximum number in Array List
 */
import java.util.*;
public class MaximumList {
    public static int getLargest(ArrayList <Integer> list){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if(max<list.get(i))
                max=list.get(i);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList <Integer> list=new ArrayList<>();
        for (int i = 1; i <= 5; i++)
            list.add(sc.nextInt());
        System.out.println(getLargest(list));
        sc.close();
    }    
}
