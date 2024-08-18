/*
 Find the any pair in a sorted array list has a target sum
 list=[1,2,3,4,5,6]  target=5
 o/p=(1,4) or any one
 */

import java.util.ArrayList;
public class PairSum_1 {
    //Brute force ------------> tc O(n^2)
    public static boolean pairSumBF(ArrayList <Integer> list, int traget){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i)+list.get(j)==traget){
                    System.out.println("("+list.get(i)+", "+list.get(j)+")");
                    return true;
                }
            }
        }
        return false;
    }
    //2 pointers approch ------------> tc O(n)
    public static boolean pairSumTP(ArrayList <Integer> list, int traget){
        int lp=0, rp=list.size()-1;
        while (lp<rp) {
            int currTarget=list.get(lp)+list.get(rp);
            if(currTarget==traget){
                System.out.println("("+list.get(lp)+", "+list.get(rp)+")");
                return true;
            }
            else if(currTarget<traget)
                lp++;
            else
                rp--;
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList <Integer> list=new ArrayList<>();
        list.add(1);list.add(2);list.add(3);
        list.add(4);list.add(5);list.add(6);
        int target=5;
        System.out.println(pairSumBF(list, target));
        System.out.println(pairSumTP(list, target));
    }
}
