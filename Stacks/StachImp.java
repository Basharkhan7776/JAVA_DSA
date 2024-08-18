import java.util.*;

public class StachImp {

    // Impliment stack using ArrayList
    static class StackA {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // push
        public static void push(int data) {
            list.add(data);
        }

        // pop
        public static int pop() {
            if (isEmpty())
                return -1;
            int val = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return val;
        }

        // peek
        public static int peek() {
            if (isEmpty())
                return -1;
            return list.get(list.size() - 1);
        }
    }

    // Implimet stacks using Linked List
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class StackL {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            if (isEmpty())
                return -1;
            int val = head.data;
            head = head.next;
            return val;
        }

        public static int peep() {
            if (isEmpty())
                return -1;
            return head.data;
        }
    }

    public static void main(String[] args) {
        StackL s = new StackL();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
