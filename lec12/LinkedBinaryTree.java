public class LinkedBinaryTree<E extends Comparable<E>> {
    Node<E> root;

    public LinkedBinaryTree() {
        root = null;
    }

    public LinkedBinaryTree(E data) {
        root = new Node(data);
    }

    private class Node<E> {
        private E element;
        private Node<E> left;
        private Node<E> right;

        public Node() {
            //init empty tree
            this.left = null;
            this.right = null;
        }

        public Node(E data) {
            this.element = data;
            this.left = null;
            this.right = null;
        }

    }

    public void InOrderTraversal() {
        return InOrderTraversal(root);
    }

    public void InOrderTraversal(Node n) {
        //base case
        if (node == null) return;

        //processs left subtree
        InOrderTraversal(node.left);
        //process current node
        System.out.println(node.element);
        //processs right subtree
        InOrderTraversal(node.right);
    }

    public Node search(E key) {
        return search(root, key);
    }

    private Node search(Node node, E key) {
        if (node == null) {
            return null;
        }

        //CASE 1: we found it!
        if (key.compareTo((E) node.element) == 0) {
            return node;
        }

        //CASE 2: larger than
        if (key.compareTo((E) node.element) > 0) {
            return search(node.right, key);
        } 

        //(key.compareTo((E) node.element) < 0) {
        //CASE 3: smaller than
        return search(node.left, key);
    }
}
