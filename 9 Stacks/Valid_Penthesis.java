/*
Given a string s containing just the characters 
'(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Input: s = "()[]{}"
Output: true
Input: s = "(]"
Output: false
 */
import java.util.*;
public class Valid_Penthesis {
    public static boolean validParenthisis(String str){
        Stack<Character> s=new Stack<>();
        for (int i = 0; i < str.length(); i++) {//O(n)
            char ch=str.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                s.push(str.charAt(i));
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek()=='('&&ch==')')||
                (s.peek()=='{'&&ch=='}')||
                (s.peek()=='['&&ch==']')){
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(s.isEmpty())
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        String str="({{[]{}}[]})[]";
        System.out.println(validParenthisis(str));
    }
}