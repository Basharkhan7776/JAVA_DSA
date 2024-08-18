/*
 Subset of string like abc-----> null,a,b,c,ab,bc,ac,abc
 Using backtracking of recurson
 */
public class SubSet {
    public static void findSubSet(String str, String ans, int i){
        if(i==str.length()){
            System.out.println(ans);
            return;
        }
        findSubSet(str, ans+str.charAt(i), i+1);
        findSubSet(str, ans, i+1);
    }
    public static void main(String[] args) {
        findSubSet("abc", "", 0);
    }
}