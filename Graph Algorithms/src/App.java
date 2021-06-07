public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(3,4);

        graph.DFSVisit();
        System.out.println(graph.toString());
    }
}
