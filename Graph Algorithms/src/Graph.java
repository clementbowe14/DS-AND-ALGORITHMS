import java.util.*;

public class Graph{

    //list of adjacent nodes
    ArrayList<ArrayList<Integer>> adj;
    int[][] weight;
    
    /**
     * Creates a graph with V vertices
     * @param V
     */
    public Graph(int V){

        adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Integer>());
        }
        weight = new int[V][V];
    }
/**
 * adds a edge at vertices (u, v)
 * @param u 
 * @param v
 */
    public void addEdge(int u, int v){
        try{
            adj.get(u).add(v);
        }
        catch(Exception e){
            System.out.println("The vertices you tried does not exist");
        }
    }

    /**
     * Sets a weight for an edge (U,V) in a graph
     * @param U @param V @param W
     */
    public void setWeight(int U, int V, int W){
        weight[U][V] = W;
    }

    /**
     * Returns the weight of an edge (U,V) in a graph
     * @param U
     * @param V
     * @return
     */
    public int getWeight(int U, int V){
        return weight[U][V];
    }
    /**
     * Depth first search method that searches for visited nodes that haven't been 
     */
    public void DFSVisit(){
        boolean[] visited = new boolean[adj.size()];
        for(int i = 0; i < adj.size(); i++){
            if(!visited[i]){
                DFS(visited, i);
            }
        }
        System.out.println();
    }

    public void DFS(boolean []visited, int V){
        if(visited[V]){
            return;
        } else{
            System.out.print(V + " -> ");
            for(int i = 0; i < adj.get(V).size(); i++){
                DFS(visited, adj.get(V).get(i));
            }
        }
    }
   
    /**
     * assumes that there are no cycles in the graph
    * topologically sorts a graph using DFS
    */
   public void TopologicaSortDFS(){
      boolean[] visited = new boolean[adj.size()];
      Stack<Integer> stack = new Stack<>();
       for(int i = 0; i < adj.size(); i++){
           if(!visited[i]){
               TopSortUtil(visited, stack, i);
           }
       }
       while(!stack.isEmpty()){
           System.out.print(stack.pop() + " ");
       }
       System.out.println();
   }

   public void TopSortUtil(boolean[] visited, Stack<Integer> stack, int index){
       if(visited[index]){
           return; 
       }
       visited[index] = true;
       List<Integer> lst = adj.get(index);
       for(int i = 0; i < lst.size(); i++){
           TopSortUtil(visited, stack, lst.get(i));
       }
       stack.push(index);
   }

   /**
    * Given a directed acyclic graph dijkstra's algorithm will print the shortest path
    * from point S to point V
    * We're going to keep this simple 
    */
   public void Dijkstra(int S, int V){
       if(adj.size() == 0){
           return;
       }
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i = 0; i < adj.size(); i++){
           if(i != S)
            map.put(i, Integer.MAX_VALUE);
       }
       // base condition
       map.put(S, 0);
       PriorityQueue<Integer> queue = new PriorityQueue<>();
       queue.add(S);
       
   }

   
    /**
     * this will return the adjacency lists that exist in the graph
     */
    @Override
    public String toString(){
        String str = "";

        for(int i = 0; i < adj.size(); i++){
            System.out.print(i + ": "); 
            for(int j = 0; j < adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

        return str; 
    }
}