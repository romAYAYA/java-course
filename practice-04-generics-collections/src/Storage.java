import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage<K, V> {
    private final HashMap<K, V> map = new HashMap<>();

    public void put(K key, V val) {
        map.put(key, val);
    }

    public V get(K key) {
        return map.get(key);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public int size() {
        return map.size();
    }

    public List<K> getAllKeys() {
        var res = new ArrayList<K>();

        map.forEach((k, v) -> {
            res.add(k);
        });

        return res;
    }
}
