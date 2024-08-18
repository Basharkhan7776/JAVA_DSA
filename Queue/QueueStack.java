import java.util.*;
public class QueueStack {
    static class Queue{
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();

        public static boolean isEmpty(){
            return (s1.isEmpty());
        }

        public static void add(int data){//O(n)
            //empty s1 and fill s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            //add data 
            s1.push(data);
            //empty s2 and fill s1
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public static int remove(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            return s1.pop();
        }

        public static int peek(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
