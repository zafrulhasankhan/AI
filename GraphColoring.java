import  java.util.*;

class GraphColoring {
    private int V;
    private LinkedList<Integer> adj[];

    //Constructor
    GraphColoring(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void greedyColoring() {
        int result[] = new int[V];

        Arrays.fill(result, -1);

        result[0] = 0;
        boolean available[] = new boolean[V];
        Arrays.fill(available, true);
        for (int u = 1; u < V; u++) {
            Iterator<Integer> it = adj[u].iterator();
            while (it.hasNext()) {
                int i = it.next();
                if (result[i] != -1)
                    available[result[i]] = false;
            }
            int cr;
            for (cr = 0; cr < V; cr++) {
                if (available[cr])
                    break;
            }

            result[u] = cr;
            Arrays.fill(available, true);
        }
        for (int u = 0; u < V; u++)
            System.out.println("Vertex " + u + " ---> Color "
                    + result[u]);
    }

    public static void main(String args[]) {
        GraphColoring g1 = new GraphColoring(6);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 0);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 0);
        g1.addEdge(2, 1);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(2, 5);
        g1.addEdge(3, 1);
        g1.addEdge(3, 2);
        g1.addEdge(3, 4);
        g1.addEdge(4, 2);
        g1.addEdge(4, 3);
        g1.addEdge(4, 5);
        g1.addEdge(5, 2);
        g1.addEdge(5, 4);
        System.out.println("Coloring of graph 1");
        g1.greedyColoring();


    }
}