/*
 * Graph.java
 * Aum Desai
 * May 3rd
 * 
 * Make a graph with vertices and edges
 * 
 */


import java.util.*;

public class Graph {

    // The set of vertices and edges in the graph
    private Set<Vertex> vertices;
    private Set<Edge> edges;

    // Constructor that creates an empty graph
    public Graph() {
        this(0, 0.1);
    }

    // Constructor that creates a graph of n vertices with probability p of having an edge between each pair of vertices
    public Graph(int n, double p) {
        this.vertices = new HashSet<Vertex>();
        this.edges = new HashSet<Edge>();

        // Add n vertices to the graph
        for (int i = 0; i < n; i++) {
            addVertex();
        }

        // Add edges between each pair of vertices with probability p
        for (Vertex u : vertices) {
            for (Vertex v : vertices) {
                if (u != v && Math.random() < p) {
                    addEdge(u, v, 1.0);
                }
            }
        }
    }

    // Returns the number of vertices in the graph
    public int size() {
        return vertices.size();
    }

    // Returns an iterable object that iterates over the vertices
    public Iterable<Vertex> getVertices() {
        return vertices;
    }

    // Returns an iterable object that iterates over the edges
    public Iterable<Edge> getEdges() {
        return edges;
    }

    // Adds a new vertex to the graph
    public Vertex addVertex() {
        Vertex v = new Vertex();
        vertices.add(v);
        return v;
    }

    // Adds a new edge to the graph between vertices u and v with the given distance
    public Edge addEdge(Vertex u, Vertex v, double distance) {
        Edge e = new Edge(u, v, distance);
        edges.add(e);
        u.addEdge(e);
        v.addEdge(e);
        return e;
    }

    // Returns the edge between vertices u and v if such an edge exists, otherwise returns null
    public Edge getEdge(Vertex u, Vertex v) {
        for (Edge e : edges) {
            if ((e.getEndpoint1() == u && e.getEndpoint2() == v) || (e.getEndpoint1() == v && e.getEndpoint2() == u)) {
                return e;
            }
        }
        return null;
    }

    // Removes the given vertex from the graph if it is in the graph
    public boolean remove(Vertex vertex) {
        if (!vertices.contains(vertex)) {
            return false;
        }
        for (Edge e : vertex.incidentEdges()) {
            remove(e);
        }
        vertices.remove(vertex);
        return true;
    }

    // Removes the given edge from the graph if it is in the graph
    public boolean remove(Edge edge) {
        if (!edges.contains(edge)) {
            return false;
        }
        edge.getEndpoint1().removeEdge(edge);
        edge.getEndpoint2().removeEdge(edge);
        edges.remove(edge);
        return true;
    }

    // Uses Dijkstra's algorithm to compute the minimal distance in the graph from the given source vertex to all other vertices
    public HashMap<Vertex, Double> distanceFrom(Vertex source) {
        // Initialization
        HashMap<Vertex, Double> dist = new HashMap<>();
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingDouble(dist::get));
        HashMap<Vertex, Vertex> prev = new HashMap<>();
    
        for (Vertex v : vertices) {
            if (!v.equals(source)) {
                dist.put(v, Double.POSITIVE_INFINITY);
                prev.put(v, null);
            }
        }
    
        dist.put(source, 0.0);
        pq.offer(source);
    
        // Main loop
        while (!pq.isEmpty()) {
            Vertex u = pq.poll();
    
            for (Vertex v : u.adjacentVertices()) {
                double alt = dist.get(u) + u.getEdgeTo(v).distance();
    
                if (alt < dist.get(v)) {
                    dist.put(v, alt);
                    prev.put(v, u);
                    pq.remove(v); // O(n) time complexity - can be improved using a custom priority queue
                    pq.offer(v);
                }
            }
        }
    
        return dist;
    }

    public double getDistance(Vertex v1, Vertex v2) {
        Set<Edge> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        Map<Vertex, Double> distances = new HashMap<>();
        queue.offer(v1);
        distances.put(v1, 0.0);
        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();
            if (curr.equals(v2)) {
                return distances.get(curr);
            }
            for (Edge edge : curr.incidentEdges()) {
                if (visited.contains(edge)) {
                    continue;
                }
                Vertex neighbor = edge.other(curr);
                double dist = distances.get(curr) + edge.distance();
                if (!distances.containsKey(neighbor) || dist < distances.get(neighbor)) {
                    distances.put(neighbor, dist);
                    queue.offer(neighbor);
                }
                visited.add(edge);
            }
        }
        return Double.POSITIVE_INFINITY;
    }
    


    
}
    