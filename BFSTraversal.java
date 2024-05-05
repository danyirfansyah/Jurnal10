import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    private int nodes;
    private LinkedList<Integer> adj[];
    private Queue<Integer> vertexQueue;
    
    @SuppressWarnings("unchecked")
    public BFSTraversal(int vertex) {
        nodes = vertex;
        adj = new LinkedList[nodes];

        for (int i = 0; i < vertex; i++) {
            adj[i] = new LinkedList<>();
        }

        vertexQueue = new LinkedList<Integer>();
    }

    public void addEdge(int source, int dest) {
        adj[source].add(dest);
    }

    public void getAdj() {
        for (int i = 0; i < nodes; i++) {
            if (adj[i].size() > 0) {  
                System.out.print(convert(i) + " --> ");
                for (int j = 0; j < adj[i].size(); j++) {
                    System.out.print(convert(adj[i].get(j)) + " ");
                }
                System.out.println();
            }
        }
    }
    //

    public String convert(int s) {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        return alphabet[s];
    }


    public void bfs(int source) {
        boolean traversalOrder[] = new boolean[nodes];

        int visitedVertex = 0;
        traversalOrder[source] = true;  
        vertexQueue.add(source);


        while (!vertexQueue.isEmpty()) {
            visitedVertex = vertexQueue.poll();
            System.out.print(convert(visitedVertex) + " ");

            for (int tetangga : adj[visitedVertex]) { 
                if (!traversalOrder[tetangga]) {   
                    traversalOrder[tetangga] = true;
                    vertexQueue.add(tetangga); 
                }
            }
        }
    }

}