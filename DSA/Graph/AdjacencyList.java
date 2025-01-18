import java.util.ArrayList;
public class AdjacencyList{
    static class Edge{
        int src, dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }

    }

    public static void display(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            System.out.print(i+"->");
            for(Edge edge: graph[i]){
                System.out.print("("+edge.src+"->"+edge.dest+")");
            }
            System.out.println();
        }
    }
    // Create a graph for directed graph and unweighted graph
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

 
    }
    //undirected graph and weighted graph
    static class EdgeWeight{
            int src, dest, weight;
            public EdgeWeight(int src, int dest, int weight){
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }
        }
    public static void displayWeight(ArrayList<EdgeWeight> graph[]){
            for(int i=0; i<graph.length; i++){
                System.out.print(i+"->");
                for(EdgeWeight edge: graph[i]){
                    System.out.print("("+edge.src+"->"+edge.dest+"@"+edge.weight+")");
                }
                System.out.println();
            }
        }
    //create undirected , weighted graph
    public static void createGraphWeight(ArrayList<EdgeWeight> graph[]){
            for(int i=0; i<graph.length; i++){
                graph[i] = new ArrayList<EdgeWeight>();
            }

            graph[0].add(new EdgeWeight(0, 2, 10));
            graph[0].add(new EdgeWeight(0, 3, 2));

            graph[1].add(new EdgeWeight(1, 2, 10));
            graph[1].add(new EdgeWeight(1, 3, 15));

            graph[2].add(new EdgeWeight(2, 0, 10));
            graph[2].add(new EdgeWeight(2, 1, 10));
            graph[2].add(new EdgeWeight(2, 3, 10));

            graph[3].add(new EdgeWeight(3, 0, 10));
            graph[3].add(new EdgeWeight(3, 1, 12));
            graph[3].add(new EdgeWeight(3, 2, -10));
        }
    
    public static void main(String[] args) {
        int V=4;
        System.out.println("Directed and Unweighted Graph");
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        display(graph);

        System.out.println("Undirected and Weighted Graph");
        ArrayList<EdgeWeight> graphWeight[]= new ArrayList[V];
        createGraphWeight(graphWeight);
        displayWeight(graphWeight);
    }
}