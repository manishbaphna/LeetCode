import java.util.LinkedHashMap;

// slight variation of https://leetcode.com/problems/lru-cache/description/
// Make the Cache use Generics and return null instead of -1
public class LRUCacheGeneric<K, V> {
    private final int capacity;
    LinkedHashMap<K, V> cache;
    public LRUCacheGeneric(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    public V get(K key) {
        V value = cache.remove(key);
        if ( value == null)
            return null;

        cache.put(key, value); // 'touch' the entry for LRU logic
        return value;
    }

    public void put(K key, V value) {
        if ( value == null )
            throw new NullPointerException("value is null for key:" + key);

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
