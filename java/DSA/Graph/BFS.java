import java.util.*;
class BFS{
    static class Edge{
        int src, dest;
        Edge(int src, int dest){
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
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
        graph[6].add(new Edge(6, 5));
        graph[6].add(new Edge(6, 5));
    }

    public static void bfs(ArrayList<Edge> graph[], boolean visited[], int vertex){
       
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        while(!queue.isEmpty()){
            int front = queue.poll();
            if(visited[front]) continue;
            visited[front]=true;
            System.out.print(front+" ");
            for(int i=0;i<graph[front].size();i++){
                Edge e=graph[front].get(i);
                queue.add(e.dest);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        display(graph);
        boolean visited[] = new boolean[V];


        // System.out.println("BFS-------------->");
        // bfs(graph, visited, 0);

        System.out.println("\nBFS-------------->while there is multiple disconnected graph");
        for(int i=0; i<V; i++){

            if(visited[i]==false){
                bfs(graph, visited, i);
            }
        }
    }
}