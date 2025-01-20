
/*
    find Itinerary from tickets means journey
    eg: Chennai->Bengaluru
        Mumbai->Delhi   -------->Mumbai->Delhi->Goa->Chennai->Bengaluru
        Goa->Chennai
        Delhi->Goa
 */
import java.util.*;

public class FindItenery {
    public static ArrayList<String> findItinerary(HashMap<String, String> fromTo) {
        ArrayList<String> list = new ArrayList<>();
        // find starting point
        HashMap<String, String> toFrom = new HashMap<>();
        String st = "";
        for (String key : fromTo.keySet()) {
            toFrom.put(fromTo.get(key), key);
        }
        // check
        for (String key : fromTo.keySet()) {
            if (!toFrom.containsKey(key)) {
                st = key;// startig point
            }
        }
        //add to arraylist
        list.add(st);
        for (String key : fromTo.keySet()) {
            st = fromTo.get(st);
            list.add(st);
        }
        return list;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Chennai", "Bengaluru");
        map.put("Mumbai", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");
        System.out.println(findItinerary(map));
    }
}
