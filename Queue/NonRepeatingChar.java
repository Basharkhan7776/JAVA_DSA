/*
 Print all first non-repeating letter in the string
 i/p-aabccxb 
 o/p- a -1 b b b b x
 */
import java.util.*;
public class NonRepeatingChar {
    public static String nonRepeatLetters(String str){
        int[] freq=new int[26];
        Queue<Character> check=new LinkedList<>();
        String result="";
        for (int i = 0; i < str.length(); i++) {
            //add char in queue
            check.add(str.charAt(i));
            //store char in freq
            freq[(int)(str.charAt(i)-'a')]++;
            while(!check.isEmpty() && freq[(int)(check.peek()-'a')]>1){
                check.remove();
            }
            if(check.isEmpty())
                result+="-1";
            else
                result+=check.peek();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(nonRepeatLetters("aabccxb"));
    }
}
