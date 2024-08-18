/*WAP Compress string like given aaaabbbcc ---------> Output=a4b3c2 */
public class StringCompression {
    public static String stringCompression(String str) {//Time complexity O(n)
        StringBuilder sb=new StringBuilder("");//string builder in mutable
        for (int i = 0; i < str.length(); i++) {
            int count=1;
            char ch=str.charAt(i);
            while (i + 1 < str.length()&&ch==str.charAt(i+1)) {//First condition ensure that i is not go beyoud string length & second to check next char is same
                count++;
                i++;
            }

            sb.append(ch);

            if (count!=1) {
                sb.append(count);
            }
        }
        return sb.toString();//convert to string 
    }
    public static void main(String[] args) {
        System.out.println(stringCompression("aaaabbbcc"));
    }
}
