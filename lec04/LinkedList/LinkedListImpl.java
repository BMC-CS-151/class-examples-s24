
public class LinkedListImpl<T> {

  private Node head;

  public LinkedListImpl() {
    head = new Node();
  }

  private class Node<T> {

    public T data;
    public Node next;

    public Node() {
      this.next = null;
    }

    public Node(T data) {
      this.data = data;
    }
  }

  public Node find(T data) {
    Node node = head;
    while (node.next != null) {
      if (node.data.equals(data)) {
        return node;
      }

      node = node.next;
    }
    //start at the head and loop until 
    // (a) you hit the tail (node.next == null) OR
    // (b) you find the element (current node.data.equals(data))
    return null;
  }


  public void insertHead(T data) {
    Node newNode = new Node(data);
    newNode.next = head.next;
    head.next = newNode;
    // 1. Create new node
    // 2. have new node point to head
    // 3. update the head to point to the new node
  }

  public void insertTail(T data) {
    Node newNode = new Node(data);
    Node node = head;
    while (node.next != null) {
      node = node.next;
    }

    node.next = newNode;

    // 1. create a new node
    // 2. find the last node
    // 3. make the last node point to newest
  }


  public void remove(T data) {
    Node node = head;
    Node leftNode = null;
    while (node.next != null) {
      if (node.data.equals(data)) {
        leftNode.next = node.next;
      }

      leftNode = node;
      node = node.next;
    }

     

    // 1. find the node to remove
    // 2. fix the left node to point to something
  }

  public void print() {
    Node currNode = head.next;

    while (currNode != null) {
      System.out.print(currNode.data + " -> ");
      currNode = currNode.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    LinkedListImpl<Integer> list = new LinkedListImpl<>();
    list.print();

    list.insertTail(0);
    list.print();
    list.insertTail(1);
    list.print();
    list.insertHead(2);
    list.print();
  }

}
