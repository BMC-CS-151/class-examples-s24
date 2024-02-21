import java.util.Iterator;
import java.util.List;

//1. implements ....
public class ExpandableArrayImpl <E> implements Iterable {

    private E[] data;
    private int numElems;

    public ExpandableArrayImpl(int size) {
        this.data = (E[]) new Object[size];
    }

    public ExpandableArrayImpl() {
        this.data = (E[]) new Object[10];
    }

    //2. implement the required interface
    public Iterator<E> iterator() {
        return new ExpandableArrayIterator();
    }

    //3.nested class (not templated bc  the outer class already is)
    class ExpandableArrayIterator implements Iterator {
        //4. need to implement the required interface methods for Iterator
        //5. Ask if anyone has design ideas for how to implement this?
        private int itr;

        public E next() {
            E elem = data[itr];
            itr++;
            return elem;
        }


        public boolean hasNext() {
            return itr < numElems;
        }


    }

    //6. now, test it.
    public static void main(String[] args) {
        ExpandableArrayImpl<Integer> e = new ExpandableArrayImpl<Integer>();
        e.insert(1);
        e.insert(7);
        e.insert(100);

        Iterator<Integer> itr = e.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }


    private void expand() {
        //expand
        E[] newData = (E[]) new Object[numElems*2];
        for (int i=0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }

        this.data = newData;
    }

    public int size() {
        return numElems;
    }

    public void insert(E item) {
        if (numElems >= data.length) {
            expand();
            System.out.println("expanding");
        }

        E[] newData = (E[]) new Object[this.data.length];
        newData[0] = item;
        for (int i=0; i < this.data.length; i++) {
            if (this.data[i] == null) break;
            newData[i+1] = this.data[i];
        }

        this.data = newData;
        numElems += 1;
    }

    public void insert(E item, int index) {
        if (index > numElems) {
            throw new ArrayIndexOutOfBoundsException(); 
        }

        if (numElems >= data.length) {
            expand();
        }

        E[] newData = (E[]) new Object[data.length];

        boolean inserted = false;
        for (int i=0; i < this.data.length; i++) {
            if (i == index) {
                newData[i] = item; 
                inserted = true;
                continue;
            } 

            if (inserted) {
                newData[i] = this.data[i-1];
            } else {
                newData[i] = this.data[i];
            }
        }

        this.data = newData;
        numElems += 1;
    }

    public E remove(int index) {
        E[] newData = (E[]) new Object[data.length];

        boolean deleted = false;
        E deletedElem = null;
        for (int i=0; i < this.data.length; i++) {
            if (i == index) {
                deleted = true;
                deletedElem = this.data[i];
            }

            if (deleted) {
                if (i+1 >= this.data.length) {
                    newData[i] = null;
                } else {
                    newData[i] = this.data[i+1];
                }
            } else {
                newData[i] = this.data[i];
            }
        }
        this.data = newData;

        return deletedElem;
    }


    public void set(E elem, int index) {
        this.data[index] = elem;
    }

    public String toString() {
        String s = "";
        for (int i=0; i<numElems; i++) {
            s += this.data[i] + ", ";
        } 
        return s;
    }

    public E get(int index) {
        return this.data[index];
    } 

}
