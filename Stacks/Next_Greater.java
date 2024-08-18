/*
 The next greater element of some element
 x in an Array is the first greater element
 that is right of x
 arr=[6,8,0,1,3]  o/p-> next Greater=[8,-1,1,3,-1]
 */
import java.util.*;
public class Next_Greater {
    public static void nextGreater(int[] arr, int[] nextGreat){//O(n)
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty()&&arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreat[i]=-1;
            }else{
                nextGreat[i]=arr[s.peek()];
            }
            s.push(i);
        }
    }
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }
    public static void nextSmaller(int[] arr,int[] nextSmall){
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<arr.length;i++){//right sa
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextSmall[i]=-1;
            }else{
                nextSmall[i]=arr[s.peek()];
            }
            s.push(i);
        }
        printStack(s);
    }
    public static void main(String[] args) {
        int[] arr={6,8,0,1,3};
        int[] nextGreat=new int[arr.length];
        int[] nextSmall=new int[arr.length];
        nextGreater(arr, nextGreat);
        System.out.println(Arrays.toString(nextGreat));
        nextSmaller(arr, nextSmall);
        System.out.println(Arrays.toString(nextSmall));
    }
}