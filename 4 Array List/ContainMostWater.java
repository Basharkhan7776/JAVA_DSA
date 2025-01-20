/*
 Container with most water :-
 For given n lines on x-axis, use 2 lines to
 form the container such that it holds maximum
 water. h=[1,8,6,2,5,4,8,3,7] -----> o/p=49
 */

import java.util.ArrayList;

public class ContainMostWater {
    //Brute force approch -------> tc O(n^2)
    public static int maxWater(ArrayList <Integer> height){
        int maxWater=0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i+1; j < height.size(); j++) {
                int currWater=(Math.min(height.get(i),height.get(j)))*(j-i);// curr W=ht*wdth
                maxWater=Math.max(currWater,maxWater);
            }
        }
        return maxWater;
    }
    //Two pointers approch -------> tc O(n)
    public static int maxWaterTwo(ArrayList <Integer> height){
        int lp=0, rp=height.size()-1, maxWater=0;
        while(lp<rp){
            //calculation
            int currWater=(Math.min(height.get(lp),height.get(rp)))*(rp-lp);
            maxWater=Math.max(currWater,maxWater);
            //Updation
            if(lp<rp)
                lp++;
            else
                rp--;
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList <Integer> height=new ArrayList<>();
        height.add(1); height.add(8); height.add(6);
        height.add(2); height.add(5); height.add(4); 
        height.add(8); height.add(3); height.add(7);
        System.out.println(maxWater(height));
        System.out.println(maxWaterTwo(height));
    }
}
