/*
  Push Value at the bottom of stack
 */
import java.util.*;
public class PushAtBottom {
    public static void pushAtBottom(Stack<Integer> s,int data){//O(n)
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int temp=s.pop();
        pushAtBottom(s, data);
        s.push(temp);
    }
    public static void main(String[] args) {
        Stack <Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s, 10);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}