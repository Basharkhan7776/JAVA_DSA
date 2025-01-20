/*
    Given Arr of jobs has dedline and profit
    if the job is finished before the deadline.
    Every job takes single unit time, min posible
    deadline for any job is 1. Maximize the total
    if only one job can scheduled at a time
    job A=4,20
    job B=1,10  ----> ans= C, A
    job C=1,40
    job D=1,30
 */

import java.util.*;

public class Job_Sequencing {
    public static ArrayList<Integer> sequencing(int[][] jobs) {
        ArrayList<Integer> list = new ArrayList<>();
        // Sorting
        Arrays.sort(jobs, Comparator.comparingDouble(o -> o[1]));
        int time = 0;
        for (int i = jobs.length - 1; i >= 0; i--) {
            if (jobs[i][0] > time) {
                list.add(jobs[i][1]);
                time++;
            }
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println("Profit = " + sum);
        return list;
    }

    public static void main(String[] args) {
        int[][] jobs = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        System.out.println("Jobs = " + sequencing(jobs));
    }
}
