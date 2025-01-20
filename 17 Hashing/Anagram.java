
/*
  Given two string and check Anagram 
  ---> two word which have same words exactly 
  one times but rearrange form
  Example : Listen and Silent
 */
import java.util.*;

public class Anagram {
    public static boolean isAnagram(String s, String t) {// O(n)
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                if (map.get(t.charAt(i)) == 1) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "tulip";
        String t = "lipid";
        System.out.println(isAnagram(s, t));
    }
}
