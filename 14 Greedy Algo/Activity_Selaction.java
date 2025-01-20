
/*
 You are given n activity with their time start and 
 end times. Select the maximum number of activity
 that can be perform by single persion assum that
 person can done single activity at a particular 
 time
   Start-[10,12,20] -----> o/p = 2{A0, A1}
   End-[20,25,30]
 */
import java.util.*;

public class Activity_Selaction {
    public static ArrayList activity(int[] start, int[] end) {
        ArrayList<Integer> act = new ArrayList<>();
        act.add(0);
        int count = 1;
        int p1 = start[0], p2 = end[0];
        for (int i = 1; i < start.length; i++) {
            if (p2 <= start[i]) {
                p2 = end[i];
                p1 = start[i];
                act.add(i);
                count++;
            }
        }
        System.out.println("Maximum number of Activity = " + count);
        return act;
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };
        System.out.println("Inference = " + activity(start, end));
    }
}
