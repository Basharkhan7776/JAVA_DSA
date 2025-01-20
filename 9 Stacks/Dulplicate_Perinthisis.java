/*
    Find out Duplicate penthisis of given statement 
    ((a+b)) ---> True
 */
import java.util.*;
public class Dulplicate_Perinthisis {
    public static boolean isDuplicate(String str){//O(n)
        Stack<Character> s=new Stack<>();
        if(str.length()==1)
            return false;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            //Closing brackits
            if(ch==')'){
                int count=0;
                while(s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1)
                    return true;
                else
                    s.pop();
            }
            else{//opening, operand, operatior
                s.push(ch);
            }

        }
        return false;
    }
    public static void main(String[] args) {
        String str="((a+b))";
        String str2="(a+b+(a+b))";
        System.out.println(isDuplicate(str));
        System.out.println(isDuplicate(str2));
    }
}
