/*
 Reverse a Stack without using extra memory
 */
import java.util.Stack;
public class ReverseStack {
    public static void pushAtBottom(Stack<Integer> s,int data){//O(n)
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int temp=s.pop();
        pushAtBottom(s, data);
        s.push(temp);
    }
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty())
            return;
        int top=s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void main(String[] args) {
        Stack <Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.toString());
        reverseStack(s);
        System.out.println(s.toString());
    }
}
