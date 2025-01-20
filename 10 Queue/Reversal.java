//reverse Queue with optamized approch
import java.util.*;
public class Reversal {
    public static void reversQueue(Queue<Integer> q){
        Stack<Integer> s=new Stack<>();
        //Filling in stacks
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        //Empting stack
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=10;i++)
            q.add(i);
        reversQueue(q);
        System.out.println(q);
    }
}