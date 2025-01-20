/*For a given string convert first letter of each word to upper case */
public class FirstupperCase {
    public static String firstUpperCase(String str) {
        StringBuilder sb=new StringBuilder("");//as a null String in builder form

        sb.append(Character.toUpperCase(str.charAt(0)));//Converting First char of string to uppercase

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i)==' '&&i<str.length()-1) {
                sb.append(" "+Character.toUpperCase(str.charAt(i+1)));
                i++;
            }
            else{
            sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(firstUpperCase("hello world good to see you nice"));
    }
}
