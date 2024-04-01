import java.util.AbstractMap.SimpleEntry;

public class ArrayMap<K,V>  {
    //TODO 1: create an instance variable for the underlying array named arr

    private SimpleEntry<K, V>[] arr;
    private int size;

    public ArrayMap() {
        arr = new SimpleEntry[3];
        size = 0;
    }

    private void expand() {
        //expand
        SimpleEntry<K,V>[] newData = new SimpleEntry[size*2];
        for (int i=0; i < size(); i++) {
            newData[i] = arr[i];
        }

        arr = newData;
    }


    public V get(K key) {
        for (int i=0; i<size(); i++) {
            if (key.equals(arr[i].getKey())) {
                return arr[i].getValue();
            }
        }
        return null;
    }

    public V put(K key, V value) {
        //if k is not in arr, add it and return null
        //else replace with new value and return the old value

        if (size()+1 >= arr.length) {
            expand();
        }

        for (int i=0; i<size(); i++) {
            if (key.equals(arr[i].getKey())) {
                V tmp = arr[i].getValue();
                arr[i].setValue(value);
                return tmp;
            }

        }

        arr[size] = new SimpleEntry(key, value);
        size += 1;
        return null;

    }

    public V remove(K key) {
        //if k exists, remove it from arr and return the associated value
        //if not, return null

        for (int i=0; i<size(); i++) {
            if (key.equals(arr[i].getKey())) {
               V tmp = arr[i].getValue();
               arr[i] = null; //do we need this???

               //TODO: check for when it's full!!
               //
               for (int j=i; j<size(); j++) {
                    //shift everything over
                    arr[j] = arr[j+1];
               }
               

               size -= 1;
               return tmp;
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
        ArrayMap<String, Integer> map = new ArrayMap();
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
