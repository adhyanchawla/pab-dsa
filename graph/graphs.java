import java.util.*;

public class graphs{

    //graph creation using adjacency list
    public static class Edge{
        int vtx;
        int nbr;
        int len;

        public Edge(int vtx, int nbr, int len)
        {
            this.vtx = vtx;
            this.nbr = nbr;
            this.len = len;
        }
    }

    public static void addEdge(ArrayList<Edge>[]graph, int v1, int v2, int len)
    {
        Edge e = new Edge(v1, v2, len);
        Edge e1 = new Edge(v2, v1, len);
        graph[v1].add(e);
        graph[v2].add(e1);
    }

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[vtces];

        for(int i = 0; i < vtces; i++)
        {
            graph[i] = new ArrayList<>();
        }

        // for(int i = 0; i < vtces; i++)
        // {
        //     int v1 = scn.nextInt();
        //     int v2 = scn.nextInt();
        //     int len = scn.nextInt();

        //     graph[v1].add(new Edge(v1, v2, len));
        //     graph[v2].add(new Edge(v2, v1, len));
        // }

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 40);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 10);
        addEdge(graph, 3, 4, 8);
        addEdge(graph, 4, 5, 3);
        addEdge(graph, 4, 6, 10);
        addEdge(graph, 5, 6, 5);

        display(graph);
    }

    public static void display(ArrayList<Edge>[] graph)
    {
        for(int i = 0; i < graph.length; i++)
        {
            System.out.print(i + " --> ");
            for(int j = 0; j < graph[i].size(); j++)
            {
                Edge e = graph[i].get(j);
                System.out.print(e.vtx + " - " + e.nbr + " @ " + e.len + ", ");
            }
            System.out.println();
        }
    }

}