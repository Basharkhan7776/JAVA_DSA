
/*
    Count how many times lowercase vowels occurred in a String entered by the user. 
*/
import java.util.*;

public class CountLowCase {
    public static int countLowerCase(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == Character.toLowerCase(str.charAt(i)))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countLowerCase("Hello"));
    }
}
