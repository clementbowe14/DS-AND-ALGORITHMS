import java.util.*;

public class Graph{

    //list of adjacent nodes
    ArrayList<ArrayList<Integer>> adj;
    
    /**
     * Creates a graph with V vertices
     * @param V
     */
    public Graph(int V){

        adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Integer>());
        }
    }
/**
 * adds a edge at vertic (u, v)
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
     * Depth first search method that searches for visited nodes that haven't been 
     */
    public void DFSVisit(){
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < adj.size(); i++){
            if(!visited.contains(i)){
                DFS(visited, i);
            }
        }
        System.out.println();
    }

    public void DFS(Set<Integer> visited, int V){
        if(!visited.add(V)){
            return;
        } else{
            System.out.print(V + " -> ");
            for(int i = 0; i < adj.get(V).size(); i++){
                DFS(visited, adj.get(V).get(i));
            }
        }
    }
   
    /**
    * topologically sorts a graph using DFS
    */
   public void TopologicaSortDFS(){
       Set<Integer> visited = new HashSet<>();
       for(int i = 0; i < adj.size(); i++){
           if(!visited.contains(i)){
               TopSortUtil
           }
       }
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