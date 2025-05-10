package arrays.medium;

import java.util.*;

public class RandomizedSet {

    Map<Integer, Integer> set;
    List<Integer> queue;
    Random random;

    public RandomizedSet() {
        set = new HashMap<>();
        queue = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        Integer inserted = set.get(val);
        if (inserted == null) {
            queue.add(val);
            set.put(val, queue.size() - 1);
        }
        return inserted == null;
    }

    public boolean remove(int val) {
        if (!set.containsKey(val)) {
            return false;
        }
        int idx = set.get(val);
        int lastElement = queue.get(queue.size() - 1);
        queue.set(idx, lastElement);
        set.put(lastElement, idx);
        queue.remove(queue.size() - 1);
        set.remove(val);
        return true;
    }

    public int getRandom() {
        int randomNumber = random.nextInt(queue.size());
        return queue.get(randomNumber);
    }
}


class RandomizedSetTest {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
        System.out.println(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomizedSet.insert(2)); // 2 was already in the set, so return false.
        System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.

    }
}
