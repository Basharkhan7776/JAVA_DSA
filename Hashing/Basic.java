import java.util.*;

public class Basic {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("New York");
        cities.add("Los Angeles");
        cities.add("Chicago");

        // Iterator it = cities.iterator();
        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }
        System.out.println("------------");
        for (String city : cities) {
            System.out.println(city);
        }
        System.out.println("---------------");
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("New York");
        lhs.add("Los Angeles");
        lhs.add("Chicago");
        for (String s : lhs) {
            System.out.println(s);
        }
        System.out.println("-------------");
        TreeSet<String> ts = new TreeSet<>();
        ts.add("New York");
        ts.add("Los Angeles");
        ts.add("Chicago");
        for (String s : ts) {
            System.out.println(s);
        }
    }
}
