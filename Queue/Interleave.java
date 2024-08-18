/*
  Interleave 2 queue of half of 1 givn Queue
  i/p-12345678910 o/p-16273849510
 */
import java.util.*;
import java.util.LinkedList;
public class Interleave {
    public static void interleaveQueue(Queue<Integer> q){
        Queue<Integer> Q=new LinkedList<>();
        int size=q.size();
        for(int i=0; i<size/2; i++){
            Q.add(q.remove());
        }
        while (!Q.isEmpty()) {
            q.add(Q.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue q=new LinkedList<>();
        for(int i=1;i<=10;i++)
            q.add(i);
        interleaveQueue(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}
