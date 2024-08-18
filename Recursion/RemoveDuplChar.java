//Remove dupplicate char in a String given char is in small letter
public class RemoveDuplChar {
    public static void removeDuplicateChar(String str, int i, StringBuilder newStr, boolean map[]){
        if(i==str.length()){
            System.out.println(newStr);
            return;
        }
        //Kaam
        char currChar=str.charAt(i);
        if(map[currChar-'a']==true){
            //Duplicate
            removeDuplicateChar(str, i+1, newStr, map);
        }
        else{
            map[currChar-'a']=true;
            removeDuplicateChar(str, i+1, newStr.append(currChar), map);
        }
    }
    public static void main(String[] args) {
        removeDuplicateChar("appnnaaccollege",0,new StringBuilder(""),new boolean[26]);
    }
}
