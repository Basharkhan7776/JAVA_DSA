/*
 Find the any pair in a sorted and rotated array list has a target sum
 [11,15,6,8,9,10] target=16 ------> (6,10)
 */

import java.util.ArrayList;

public class PairSum_2 {
    // 2 pointers approch --------> tc O(n)
    public static boolean pairSumTP(ArrayList <Integer> list, int target){
        int p;
        //breakng point
        for (p=0; p < list.size(); p++) {
            if(list.get(p)>list.get(p+1))
                break;
        }
        int rp=p, lp=p+1;
        while (lp!=rp) {
            if(list.get(lp)+list.get(rp)==target){
                System.out.println("("+list.get(lp)+", "+list.get(rp)+")");
                return true;
            }
            else if(list.get(lp)+list.get(rp)<target){
                lp=(lp+1)%list.size();
            }
            else{
                rp=(list.size()+rp-1)%list.size();
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList <Integer> list=new ArrayList<>();
        int target=26;
        list.add(11); list.add(15); list.add(6); 
        list.add(8); list.add(9); list.add(10);
        System.out.println(pairSumTP(list, target));
    }
}
