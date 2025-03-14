import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MergedTwoSortedListsTest {

    MergedTwoSortedLists DUT = new MergedTwoSortedLists();

    @Test
    void basicTest1 () {
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        cache.put(10, 200);
        cache.put(1, 10);
        cache.put(9, 101);
        cache.put(3, 12);

        System.out.println("LinkedHashMap : ");
        for (Map.Entry<Integer, Integer> m : cache.entrySet()) {
            System.out.println(m.getKey() + ":" + m.getValue());
        }

        var iter = cache.entrySet().iterator();

        System.out.println(iter.next());

        var found = cache.entrySet().stream().findFirst().get();
        System.out.println(found);

    }

    @Test
    void basicTest2 () {
        HashMap<Integer, Integer> cache = new HashMap<>();

        cache.put(10, 200);
        cache.put(1, 10);
        cache.put(9, 101);
        cache.put(3, 12);

        System.out.println("HashMap : ");
        for (Map.Entry<Integer, Integer> m : cache.entrySet()) {
            System.out.println(m.getKey() + ":" + m.getValue());
        }
    }


    @Test
    void basicTest3 () {
        TreeMap<Integer, Integer> cache = new TreeMap<>();

        cache.put(10, 200);
        cache.put(1, 10);
        cache.put(9, 101);
        cache.put(3, 12);

        System.out.println("TreeMap : ");
        for (Map.Entry<Integer, Integer> m : cache.entrySet()) {
            System.out.println(m.getKey() + ":" + m.getValue());
        }
    }

}