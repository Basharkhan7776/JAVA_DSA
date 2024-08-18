/*
 Reverse Given a String using Stack
 */
import java.util.Stack;
public class ReverseString {
    public static String reverseStr(String str){//O(n)
        Stack<Character> s=new Stack<>();
        for (int i = 0; i < str.length(); i++)
            s.push(str.charAt(i));
        StringBuilder result=new StringBuilder();
        while (!s.isEmpty())
            result.append(s.pop());
        return result.toString();
    }
    public static void main(String[] args) {
        String str="abcdef";
        System.out.println(reverseStr(str));
    }
}