import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class No380 {
}

class RandomizedSet {

    Map<Integer, Integer> map;
    ArrayList<Integer> list;
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = map.containsKey(val);
        if (res) return false;
        map.put(val, list.size() - 1);
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int loc = map.get(val);
        if (loc != list.size() - 1) {
            int lastone = list.get(list.size() - 1);
            list.set(loc, lastone);
            map.put(lastone, loc);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
