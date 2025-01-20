/*
 Swap number of i1 and i2 of array list
 */
import java.util.*;
public class SwapNum {
    public static void swapNum(ArrayList <Integer> list, int i1, int i2){
        int temp=list.get(i1);
        list.set(i1,list.get(i2));
        list.set(i2,temp);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList <Integer> list=new ArrayList<>();
        for (int i = 1; i <= 10; i++)
            list.add(sc.nextInt());
        swapNum(list, 2, 5);
        System.out.println(list);
        sc.close();
    }
}
