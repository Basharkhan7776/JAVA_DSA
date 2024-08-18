/*
Print all permutation of a String?
abc----->abc acb bac bca cab cba
 */
public class Permutation {
    public static void printPerutation(String str, String ans){//tc O(n*n!) sc O(n)
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for (int j = 0; j < str.length(); j++)
            printPerutation(str.substring(0, j)+str.substring(j+1), ans+str.charAt(j));
    }
    public static void main(String[] args) {
        printPerutation("abcd", "");
    }
}