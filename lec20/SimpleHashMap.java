import java.util.AbstractMap.SimpleEntry;

public class SimpleHashMap<K,V>  {
    private SimpleEntry<K, V>[] arr;
    private int size;
    private int N = 10001; //capacity

    public SimpleHashMap() {
        arr = new SimpleEntry[N]; 
        size = 0;
    }

    public int hash(K key) {
        int h1 = key.hashCode();
        int h2 = h1 % N;
        return Math.abs(h2); 
    }

    public V get(K key) {
       //if key is in the array, return the corresponding value
       //else return null

        int index = hash(key);

        if (arr[index] == null) {
            return null;
        }

        return (V) arr[index].getValue();
    }

    public V put(K key, V value) {
        //if k is not in arr, add it and return null
        //else replace with new value and return the old value

        int index = hash(key);

        if (arr[index] == null) {
            arr[index] = new SimpleEntry(key, value);
            size += 1;
            return null;
        }

        V oldValue = arr[index].getValue();
        arr[index].setValue(value);
        return oldValue;

    }

    public V remove(K key) {
        //if k exists, remove it from arr and return the associated value
        //if not, return null
        //return null;
        
        int index = hash(key);
        if (arr[index] == null) return null;

        V tmp = arr[index].getValue();
        arr[index] = null;
        size--;

        return tmp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        //map of everyone's grades
        SimpleHashMap<String, Integer> map = new SimpleHashMap();
        assert map.isEmpty();
        assert map.get("Elizabeth") == null;

        map.put("Elizabeth", 75);
        assert map.get("Elizabeth") == 75;
        assert map.size() == 1;

        map.put("Cinnabon", 100);
        assert map.get("Cinnabon") == 100;

        map.put("Steve", 90);
        assert map.get("Steve") == 90;

        map.put("Dianna", 95);
        assert map.get("Dianna") == 95;
        assert map.size() == 4;

        map.remove("Steve");
        assert map.get("Steve") == null;
        assert map.size() == 3;

        map.put("Elizabeth", 80);
        assert map.get("Elizabeth") == 80;
        assert map.size() == 3;


    }

    //iterator / iterables???

}
