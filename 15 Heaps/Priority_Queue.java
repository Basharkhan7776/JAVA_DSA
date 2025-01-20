import java.util.*;

public class Priority_Queue {
    static class Student implements Comparable<Student> {// overriding
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }



    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(3);// log n
        pq.add(1);
        pq.add(2);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());// O(1)
            pq.remove();// O(log n)
        }
        PriorityQueue<Student> p = new PriorityQueue<>();
        p.add(new Student("A", 4));
        p.add(new Student("B", 2));
        p.add(new Student("C", 1));
        p.add(new Student("F", 5));
        while (!p.isEmpty()) {
            System.out.println(p.peek().name + "->" + p.peek().rank);
            p.remove();
        }
    }
}
