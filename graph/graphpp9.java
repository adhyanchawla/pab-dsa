import java.util.*;



public class graphpp9{

    public static Scanner scn = new Scanner(System.in);
    public static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src, int nbr, int wt)
        {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w)
    {
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));

    }

    public static void construction()
    {
        int N = 7;

        ArrayList<Edge>[] graph = new ArrayList[N];

        for(int i = 0; i < N; i++)
        {
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 5);

        //display(graph, N);
        //boolean[] visited = new boolean[graph.length];
        //postOrder(graph, 0, 6, visited, 0, 0 + "");

        bfsPath(graph);
    }

    public static void display(ArrayList<Edge>[] graph, int N)
    {
        for(int i = 0; i < N; i++)
        {
            System.out.print(i + " -> ");
            for(Edge e : graph[i])
            {
                System.out.print(e.nbr + " " +e.wt + ", ");
            }
            System.out.println();
        }
    }
//=================================================================================================================================================
    public static int findEdge(ArrayList<Edge>[] graph, int u, int v)
    {
        ArrayList<Edge> list = graph[u];
        for(int i = 0; i < list.size(); i++)
        {
            Edge e = list.get(i);
            if(e.nbr == v)
            {
                return i;
            }
        }   

        return -1;
    }

//=================================================================================================================================================
    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v)
    {
        int i1 = findEdge(graph, u, v);
        int i2 = findEdge(graph, v, u);

        graph[u].remove(i1);
        graph[v].remove(i2);
    }

    

    public static void removeVtx(ArrayList<Edge>[] graph, int u)
    {
        ArrayList<Edge> list = graph[u];
        for(int i = list.size()-1; i >= 0; i--)
        {
            Edge e = list.get(i);
            removeEdge(graph, e.src, e.nbr);
        }
    }

//=================================================================================================================================================== 
    public static boolean hasPath(ArrayList<Edge>[] graph, int u, int v, boolean[] visited)
    {
        if(u == v)
        return true;

        visited[u] = true;
        boolean ans = false;
        for(Edge e : graph[u])
        {
            if(visited[e.nbr] == false)
            {
                ans = ans || hasPath(graph, e.nbr, v, visited);
            }
        }
        return ans;
    }

    //pre order travsersal
    public static void preOrder(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int wsf, String psf)
    {
        System.out.println(src + " -> " + wsf + " " +psf);
        visited[src] = true;
        
        for(Edge e: graph[src])
        {
            if(visited[e.nbr] == false)
            {
                preOrder(graph, e.nbr, dest, visited, wsf + e.nbr, psf + e.nbr);
            }
        }

        visited[src] = false;
    }


    // post order traversal
    public static void postOrder(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int wsf, String psf)
    {
        visited[src] = true;
        for(Edge e: graph[src])
        {
            if(visited[e.nbr] == false)
            {
                preOrder(graph, e.nbr, dest, visited, wsf + e.nbr, psf + e.nbr);
            }
        }

        
        System.out.println(src + " -> " + wsf + " " +psf);
        visited[src] = false;
    }
//===============================================================================================================================================
    //lightest path
    public static pathPair smallestPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis)
    {
        if (src == dest) {
            pathPair base = new pathPair();
            base.psf += src;
            base.wsf = 0;

            return base;
        }

        vis[src] = true;
        pathPair myAns = new pathPair();
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                pathPair recAns = smallestPath(graph, e.nbr, dest, vis);
                if (recAns.wsf != -1 && recAns.wsf + e.wt < myAns.wsf) {
                    myAns.psf = src + recAns.psf;
                    myAns.wsf = recAns.wsf + e.wt;
                }
            }
        }
        vis[src] = false;
        return myAns;
    }

    public static class pathPair {
        String psf = "";
        int wsf = -1;
    }

    public static void smallestPath01(ArrayList<Edge>[] graph, int src, int dest) {
        boolean[] vis = new boolean[graph.length];
        pathPair ans = smallestPath(graph, src, dest, vis);

        System.out.println("Smallest Path: " + ans.psf + " of weight: " + ans.wsf);
    }

    public static void heaviestPath01(ArrayList<Edge>[] graph, int src, int dest) {
        boolean[] vis = new boolean[graph.length];
        pathPair ans = heaviestPath(graph, src, dest, vis);

        System.out.println("Heaviest Path: " + ans.psf + " of weight: " + ans.wsf);
    }

    //heaviest path
    public static pathPair heaviestPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
        if (src == dest) {
            pathPair base = new pathPair();
            base.psf += src;
            base.wsf = 0;

            return base;
        }

        vis[src] = true;
        pathPair myAns = new pathPair();
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                pathPair recAns = heaviestPath(graph, e.nbr, dest, vis);
                if (recAns.wsf != -1 && recAns.wsf + e.wt > myAns.wsf) {
                    myAns.psf = src + recAns.psf;
                    myAns.wsf = recAns.wsf + e.wt;
                }
            }
        }
        vis[src] = false;
        return myAns;
    }


    public static class ceilfloorpair{
        int ceil = -(int)1e9;
        int floor = (int)1e9;
    }

    public static void ceilFloorPath(ArrayList<Edge>[] graph, int src, int dest, int data, ceilfloorpair pair, int wsf, boolean[] visited)
    {
        if(data < wsf)
        {
            pair.ceil = Math.min(pair.ceil, wsf);
        }

        if(data > wsf)
        {
            pair.floor = Math.max(pair.floor, wsf);
        }

        visited[src] = true;

        for(Edge e : graph[src])
        {
            if(visited[e.nbr] == false)
            {
                ceilFloorPath(graph, e.nbr, dest, data, pair, wsf + e.wt, visited);
            }
        }

        visited[src] = false;

    }

    public static void ceilfloor(ArrayList<Edge>[] graph, int src, int dest)
    {
        int wt = scn.nextInt();
        boolean[] visited = new boolean[graph.length];
        ceilfloorpair pair = new ceilfloorpair();
        ceilFloorPath(graph, src, dest, wt, pair, 0, visited);
    }

//================================================================================================================================================
 public static class BFS_Pair{
     int vtx; //dest
     int wsf;
     String psf;
     public BFS_Pair(int vtx, int wsf, String psf)
     {
         this.vtx = vtx;
         this.wsf = wsf;
         this.psf = psf;
     }
 } 

 public static void bfsPath(ArrayList<Edge>[] graph)
 {
     boolean[] vis = new boolean[graph.length];

     for(int i = 0; i < graph.length; i++){
        
        Queue<BFS_Pair> q = new ArrayDeque<>();
        q.add(new BFS_Pair(i,  0, i + ""));

        while(q.size() > 0)
        {
            BFS_Pair rm = q.remove();
            if(vis[rm.vtx])
            continue;

            System.out.println(rm.vtx + " -> " + rm.psf + " @ " + rm.wsf);
            vis[rm.vtx] = true;
            for(Edge e: graph[rm.vtx])
            {
                if(!vis[e.nbr])
                q.add(new BFS_Pair(e.nbr, e.nbr + rm.wsf, rm.psf + e.nbr));
            }
        }
     }
     
 }

    //gcc solved on portal 
    //complexity O(E) calling
    //complexity O(V + E)

    //is graph connected
//=================================================================================================================================================
    public static void main(String[] args)
    {
        construction();
    }

}