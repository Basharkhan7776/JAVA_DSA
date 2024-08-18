/*
   function to reverse the array list
 */
import java.util.*;
public class ReverseList {
    public static void reverse(ArrayList <Integer> list){
        for(int i=list.size()-1;i>=0;i--)
            System.out.print(list.get(i)+" ");
    }
    public static void main(String[] args) {
        ArrayList <Integer> list=new ArrayList<>();
        for (int i = 1; i <= 5; i++)
            list.add(i);
        for(int i=0;i<list.size();i++)
            System.out.print(list.get(i)+" ");
        System.out.println();
        reverse(list);
    }
}
