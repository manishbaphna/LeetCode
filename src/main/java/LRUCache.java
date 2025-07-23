import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/lru-cache/description/
public class LRUCache {

    private final int capacity;

    LinkedHashMap<Integer, Integer> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        Integer value = cache.remove(key);
        if ( value == null)
            return -1;

        cache.put(key, value); // 'touch' the entry for LRU logic
        return value;
    }

    public void put(int key, int value) {
        int[] arr = {1,2,3};
        //as arr is of 'int' while Java Collections need Integer so need to use boxed
        HashSet<Integer> s = new HashSet<>(Arrays.stream(arr).boxed().collect(Collectors.toSet()));



        String[] fruitArray = {"apple", "orange", "banana", "apple", "pear"};
        HashSet<String> fruitSet = new HashSet<>(Arrays.asList(fruitArray));

        boolean keyExists = cache.containsKey(key);

        if (keyExists)
            cache.remove(key);
        else if (cache.size() == capacity) {
            var keyToRemove = cache.entrySet().iterator().next().getKey();
            cache.remove(keyToRemove);
        }

        cache.put(key, value);
    }


}
