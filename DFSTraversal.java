import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSTraversal {
    private int vertex;

    private LinkedList<Integer> adj[];

    private boolean visited[];


    @SuppressWarnings("unchecked")
    public DFSTraversal(int v) {
        vertex = v;
        adj = new LinkedList[vertex]; 

        for (int i = 0; i < vertex; i++) {
            adj[i] = new LinkedList<>();
        }

        visited = new boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            visited[i] = false;
        }
    }


    public void addEdge(int source, int dest) {
        adj[source].add(dest);
    }


    public String convert(int s) {
        String alphabet[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        return alphabet[s];
    }


    public void dfs(int source) {

        Stack<Integer> stack = new Stack<>();

        stack.push(source);

        while (stack.empty() == false) {
            source = stack.peek();
            stack.pop();

            if (visited[source] == false) {
                System.out.print(convert(source) + " ");
                visited[source] = true;
            }

            Iterator<Integer> it = adj[source].iterator();

            while (it.hasNext()) {
                int v = it.next();
                if (!visited[v]) {
                    stack.push(v);
                }
            }
        }
    }

}
