import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two number = ");
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.print("Enter operator = ");
        char op=sc.next().charAt(0);
        switch (op) {
            case '+':
                System.out.println(a+b);
                break;
            case '-':
                System.out.println(a-b);
                break;
            case '*':
                System.out.println(a*b);
                break;
            case '/':
                System.out.println(a/b);
                break;
            case '%':
                System.out.println(a%b);
                break;
            case '^':
                System.out.println(Math.pow(a,b));
                break;
            default:
                System.out.println("Enter wrong character//");
                break;
        }
        sc.close();
    }
}
