public class Test <T> {

  //TODO 1: Make data Generic
  private T[] data;
  private int size; 
  private int numElems;

  //TODO 4: Make constructor Generic
  public Test(int size) {
    this.data = (T[]) new Object[size];
  }

  //TODO 2: Make insert Generic
  public void insert(T item) {
    this.data[numElems] = item;
    numElems += 1;
  }

  //TODO 3: Make get Generic
  public T get(int index) {
    return this.data[index];
  } 

  public static <T> void print(T t) {
    System.out.println(t);
  }

  public void print() {
    System.out.println("Data:");
    for (int i=0; i < this.data.length; i++) {
      System.out.println(data[i]);
    }
  }

  public static void main(String[] args) {
    Test e = new Test(4);
    e.insert(100);
    e.insert(15.5);
    e.insert(new Object());
    e.insert(new Student("Elizabeth", 27));
    e.print();
    System.out.println(e.get(3));
  }
}
