
public class DoublyLinkedListImpl<T> {

  private Node head;
  private Node tail; //NOTICE TAIL

  public LinkedListImpl() {
    head = new Node();
    tail = new Node();

    head.next = tail; //In an empty linked list, head and tail point to eachother
    tail.prev = head;
  }

  private class Node<T> {

    public T data;
    public Node next;

    //TODO 1: add a prev field and initialize it in the constructor
    public Node prev;

    public Node() {
      this.next = null;
      this.prev = null;
    }

    public Node(T data) {
      this.data = data;
    }
  }

  //TODO 2: fix insertHead 
  public void insertHead(T data) {
    // 1. Create new node
    Node newNode = new Node(data);
    // 2. have new node point to head
    newNode.next = head.next;
    // 3. update the head to point to the new node

    head.next.prev = newNode;
    head.next = newNode;
    // new: fix prev and tail accordingly
    newNode.prev = head;

  }


  //TODO 3: fix insertTail 
  public void insertTail(T data) {

    // 1. create a new node
    Node newNode = new Node(data);

    // 2. find the last node - it's tail!

    // 3. make the last node point to newest
    
    newNode.prev = tail.prev;
    newNode.next = tail;
    tail.prev.next = newNode;
    tail.prev = newNode;

    //new: fix prev and tail accordingly (notice step 3)
  }


  //TODO 4: fix remove
  public void remove(T data) {
    Node node = head;
    Node leftNode = null;

    // 1. find the node to remove
    while (node.next != null) {

      // 2. fix the left node to point to something
      if (node.data.equals(data)) {
        leftNode.next = node.next;
        node.prev = leftNode;
        break;
      }

      leftNode = node;
      node = node.next;
    }

  }


  //TODO 5: create an insertBefore method
  public void insertBefore(Node after, T newData) {
    Node nodeToInsert = new Node(newData); 

    nodeToInsert.prev = after.prev;
    nodeToInsert.next = after;
    after.prev.next = nodeToInsert;
    after.prev = nodeToInsert;

  }
}
