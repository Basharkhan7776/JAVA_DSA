import java.util.*;
public class PalindromeWord {
    public static Boolean palindrome(String str) {
        for (int i=0; i < str.length(); i++) {
            if (str.charAt(i)!=str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String");
        String str=sc.next();
        System.out.println("Palindrome --------> "+palindrome(str));
        sc.close();
    }
}
