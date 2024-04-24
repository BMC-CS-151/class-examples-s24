import java.util.LinkedList;

class ListGraph {
    private int numV; 
    private int capacity;
    private LinkedList<Integer>[] data; 

    ListGraph(int capacity) {
       this.capacity = capacity;
       this.numV = 0; 
       data = new LinkedList[capacity];
    }

    ListGraph() {
       this.capacity = 100; 
       this.numV = 0;
       data = new LinkedList[capacity];
    }

    public void addVertex() {
        if (this.numV+1 >= capacity) {
            //expand
        }         

        data[numV] = new LinkedList<Integer>();
        numV += 1;

        //add a vertex
    }

    //Add a directed edge from v to w
    public void addEdge(int v, int w) {
       data[v].add(w); 
    }

    //Remove a vertex from the graph
    public void removeVertex(int v) {
        data[v] = null;

        for (int i=0; i<numV; i++) {
            LinkedList<Integer> list = data[i];
            if (list == null) continue;

            if (list.contains(v)) { //O(n)
                list.remove((Integer) v); //O(n)
            }
        }
        
        //Remember to updates edges which might have links to v
        //use LinkedList remove(Object) method
    }

    //Remove the edge from v to w
    public void removeEdge(int v, int w) {
        //use LinkedList remove(Object) method

        data[v].remove((Integer) w);
    }

    public void printGraph() {
        for (int v = 0; v < numV; ++v) {
            if (data[v] == null) continue;
            System.out.println("Adjacency list of vertex " + v);
            for (Integer pCrawl : data[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        // Create a directed graph with 5 vertices
        ListGraph graph = new ListGraph();
        //add 5 vertices (0, 1, 2, 3, and 4)
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 1);
        graph.addEdge(4, 3);

        // Add a 5th vertex and an edge
        graph.addVertex();
        graph.addEdge(4, 5);

        // Print the adjacency list representation of the graph
        graph.printGraph();

        graph.removeEdge(0, 1);
        graph.removeVertex(4);

        // Print the modified graph
        System.out.println("After removing edge (0, 1) and vertex 4:");
        graph.printGraph();
    }
}
