class Solution {
    class Graph{
        ArrayList<Integer>[]adj;
Graph(int n)
{
    adj=new ArrayList[n];
    for(int i=0;i<n;i++)
        adj[i]=new ArrayList<>();
}
        public void addEdge(int src,int dest)
        {
            adj[src].add(dest);
            adj[dest].add(src);
        }
    }
    public boolean DFS(int src,int dest,boolean []vis,Graph g)
    {
        if(src==dest) return true;
        if(vis[src]==true)
            return false;
        vis[src]=true;
        for(int nbr:g.adj[src])
        {
 if(DFS(nbr,dest,vis,g)==true)
     return true;
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g=new Graph(n);
        for(int i=0;i<edges.length;i++)
        {
          g.addEdge(edges[i][0],edges[i][1]);  
        }
        boolean []vis=new boolean[n];
        return DFS(source,destination,vis,g);
    }
}