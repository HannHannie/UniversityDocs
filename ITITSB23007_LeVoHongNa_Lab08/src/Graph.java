import java.util.*;
class Node{
    String name;
    public Node(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

class Edge{
    Node from;
    Node to;
    int weight;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class Graph{
    private Map<Node,List<Edge>> adjList; //adjacency

    public Graph(){
        this.adjList = new HashMap<>();
    }
    public void addNode(Node node){
        //add only when it hasn't existed yet
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(Node from, Node to, int weight){
        addNode(from);
        addNode(to);
        adjList.get(from).add(new Edge(from, to, weight));
        adjList.get(to).add(new Edge(to, from, weight)); //undirected
    }

    //get the adjacency edge of the given node
    public List<Edge> getEdges(Node node){
        return adjList.get(node);
    }

    //get the set of nodes from adjList
    public Set<Node> getNodes(){
        return adjList.keySet();
    }

    //Depth First Search
    private List<List<Node>> DFS(Node start, Node end){
        List<List<Node>> allPaths = new ArrayList<>();
        Stack<List<Node>> st = new Stack<>();
        st.push(Arrays.asList(start));
        while(!st.isEmpty()){
            List<Node> path = st.pop(); //get a path from the stack
            Node last = path.get(path.size() - 1); //get the last node of the path
            if (last.equals(end)){
                allPaths.add(path);
            } else {
                //if it didn't reach the end then
                for (Edge edge : adjList.get(last)){
                    if (!path.contains(edge.to)){ //skip the visited node
                        List<Node> newPath = new ArrayList<>(path); //copy the current path to the newPath
                        newPath.add(edge.to);
                        st.push(newPath);
                    }
                }
            }
        }
        return allPaths;
    }

    //Breadth First Search
    public List<List<Node>> BFS(Node start, Node end){
        List<List<Node>> allPaths = new ArrayList<>();
        Queue<List<Node>> qu = new LinkedList<>();
        qu.add(Arrays.asList(start));

        while(!qu.isEmpty()){
            List<Node> path = qu.poll();
            Node last = path.get(path.size() - 1);
            if(last.equals(end)){
                allPaths.add(path);
            } else {
                for (Edge edge : adjList.get(last)){
                    if(!path.contains(edge.to)){
                        List<Node> newPath = new ArrayList<>(path);
                        newPath.add(edge.to);
                        qu.add(newPath);
                    }
                }
            }
        }
        return allPaths;
    }

    //SHORTEST PATH ALGORITHMS
    //Dijkstra Algorithms
    public List<Node> Dijkstra(Node start, Node end){
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> prev = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        for(Node node : adjList.keySet()){
            distances.put(node, Integer.MAX_VALUE); //set initial value
        }

        distances.put(start, 0);
        queue.add(start);

        while(!queue.isEmpty()){
            Node current = queue.poll();

            if(current.equals(end)) break; //break while loop

            for(Edge edge : adjList.get(current)){
                int newDistance = distances.get(current) + edge.weight;
                if(newDistance < distances.get(edge.to)){
                    distances.put(edge.to, newDistance);
                    prev.put(edge.to, current); //Node: current -> edge.to
                    queue.add(edge.to);
                }
            }
        }
        if (distances.get(end) == Integer.MAX_VALUE){
            return Collections.emptyList();
        }
        List<Node> path = new ArrayList<>();
        for (Node curr = end; curr != null; curr = prev.get(curr)){ //go backward from then end to start
            path.add(curr);
        }
        Collections.reverse(path);
        return path;
    }

    //BFS Algorithms
    public List<Node> ShortestPathBFS(Node start, Node end){
        Map<Node, Node> prev = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()){
            Node curr = queue.poll();

            if (curr.equals(end)) break;

            for (Edge edge : adjList.get(curr)){
                Node ConnectTo = edge.to;
                if (!visited.contains(ConnectTo)){
                    visited.add(ConnectTo);
                    prev.put(ConnectTo, curr);
                    queue.add(ConnectTo);
                }
            }
        }

        if(!prev.containsKey(end) && !start.equals(end)){
            return Collections.emptyList();
        }

        List<Node> path = new ArrayList<>();
        for(Node curr = end; curr != null; curr = prev.get(curr)){
            path.add(curr);
            if (curr.equals(start)) break;
        }
        Collections.reverse(path);
        return path;
    }

    public int calculateWeight(List<Node> nodes){
        int weight = 0;
        for (int i = 0; i < nodes.size() - 1; i++){
            Node from = nodes.get(i);
            Node to = nodes.get(i + 1);
            for (Edge edge : adjList.get(from)){
                if (edge.to.equals(to)){
                    weight += edge.weight;
                }
            }
        }
        return weight;
    }

    public String printPath(List<Node> nodes){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (Node node : nodes){
            sb.append(node.getName() + " ");
        }
        sb.append("]");
        return sb.toString();
    }
}
class MapApp{
    public static void main(String[] args) {
        Graph graph = new Graph();
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        Node J = new Node("J");
        Node K = new Node("K");
        Node L = new Node("L");
        Node N2 = new Node("N2");

        graph.addEdge(A, B, 6);
        graph.addEdge(A, N2, 10);
        graph.addEdge(B, C, 11);
        graph.addEdge(B, D, 14);
        graph.addEdge(B, N2, 12);
        graph.addEdge(C, E, 6);
        graph.addEdge(C, F, 3);
        graph.addEdge(C, N2, 12);
        graph.addEdge(D, K, 15);
        graph.addEdge(D, H, 6);
        graph.addEdge(D, E, 4);
        graph.addEdge(E, H, 12);
        graph.addEdge(F, N2, 8);
        graph.addEdge(F, H, 16);
        graph.addEdge(F, I, 6);
        graph.addEdge(G, N2, 16);
        graph.addEdge(G, I, 8);
        graph.addEdge(H, I, 13);
        graph.addEdge(H, L, 18);
        graph.addEdge(H, K, 12);
        graph.addEdge(I, L, 17);
        graph.addEdge(J, K, 9);
        graph.addEdge(J, L, 20);

        //Task 04:
        List<List<Node>> allPaths = graph.BFS(A, K);
        System.out.println("The number of paths to go from A to K is: " + allPaths.size());
        for (List<Node> path : allPaths){
            System.out.println("Path: " + graph.printPath(path) + " - Weight: " + graph.calculateWeight(path));
        }

        //Task 05:
        List<Node> AJ = graph.Dijkstra(A, J);
        System.out.println("The Shortest Path from A to J is: " + graph.printPath(AJ) + " - Weight: " + graph.calculateWeight(AJ));
        List<Node> BL = graph.Dijkstra(B, L);
        System.out.println("The Shortest Path from B to L is: " + graph.printPath(BL) + " - Weight: " + graph.calculateWeight(BL));
    }
}