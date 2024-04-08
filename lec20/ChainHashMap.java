import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;

public class ChainHashMap<K,V>  extends AbstractHashMap<K,V> {
    //TODO 1 & 2: what should our underlying array look like?
    //        fix the type of arr
    //        implement creteTable

    private LinkedList<SimpleEntry<K, V>>[] arr;
    //private SimpleEntry<K, V>[] arr; 
    private int size;
    private int N = 10000; //capacity

    public ChainHashMap() {
        size = 0;
        createTable();
    }

    protected void createTable() {
        arr = new LinkedList[N];        
    }


    /*
    public int hash(K key) {
        int h1 = key.hashCode();
        int h2 = h1 % N;
        return Math.abs(h2);
    }
    */

    //TODO 4: implement bucketGet (AbstractHashMap implements get) 

    /**
     * Returns value associated with key k in bucket with hash value h.
     * If no such entry exists, returns null.
     * @param h  the hash value of the relevant bucket
     * @param k  the key of interest
     * @return   associate value (or null, if no such entry)
     */
    protected V bucketGet(int h, K k) {
        LinkedList bucket = arr[h];

        Iterator itr = bucket.iterator();

        while (itr.hasNext()) {
            SimpleEntry elem = (SimpleEntry) itr.next();

            if (elem.getKey().equals(k)) {
                return (V) elem.getValue();
            }
        }

        return null;

        //use an iterator :)
    }


    //TODO 5: implement bucketPut (AbstractHashMap implements put) 

    /**
     * Associates key k with value v in bucket with hash value h, returning
     * the previously associated value, if any.
     * @param h  the hash value of the relevant bucket
     * @param k  the key of interest
     * @param v  the value to be associated
     * @return   previous value associated with k (or null, if no such entry)
     */
    protected V bucketPut(int h, K k, V v) {
        LinkedList bucket = arr[h];

        if (bucket == null) {
            arr[h] = new LinkedList();
            arr[h].add(new SimpleEntry(k, v));
            size += 1;
            return null;
        }


        Iterator itr = bucket.iterator();

        while (itr.hasNext()) {
            SimpleEntry elem = (SimpleEntry) itr.next();

            if (elem.getKey().equals(k)) {
                V tmp = (V) elem.getValue();
                elem.setValue(v);
                return tump;
            }

        }

        bucket.add(new SimpleEntry(k, v));
        size += 1;
        return v;

    }


    //TODO 6: implement bucketRemove (AbstractHashMap implements remove) 

    /**
     * Removes entry having key k from bucket with hash value h, returning
     * the previously associated value, if found.
     * @param h  the hash value of the relevant bucket
     * @param k  the key of interest
     * @return   previous value associated with k (or null, if no such entry)
     */
    protected V bucketRemove(int h, K k) {
        LinkedList bucket = arr[h];

        Iterator itr = bucket.iterator();

        while (itr.hasNext()) {
            SimpleEntry elem = (SimpleEntry) itr.next();
            if (elem.getKey().equals(k)) {
               V oldValue = (V) elem.getValue();
               itr.remove();
               size -= 1;
               return oldValue;
            }
        }

        return null;


    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        //map of everyone's grades
        ChainHashMap<String, Integer> map = new ChainHashMap();
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

    //iterator and iterables
    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();

        for (int i=0; i<N; i++) {
            if (arr[i] != null) {
                for (SimpleEntry<K,V> entry : arr[i]) {
                    buffer.add((Entry)entry);
                }
            }
        }

        return buffer;
    }


}
