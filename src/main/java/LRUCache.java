import java.util.LinkedHashMap;
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
