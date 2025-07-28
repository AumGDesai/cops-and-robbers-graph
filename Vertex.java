/*
 * Edge.java
 * Aum Desai
 * May 3rd
 * 
 * Vertex object that will be connected to other vertices via edges
 * 
 */


import java.util.ArrayList;
import java.util.List;

public class Vertex {

    // The collection of edges incident to this vertex
    private List<Edge> edges;

    // Constructor that initializes a new Vertex
    public Vertex() {
        edges = new ArrayList<>();
    }

    // Returns the Edge which connects this vertex and the given Vertex vertex
    // if such an Edge exists, otherwise returns null.
    public Edge getEdgeTo(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getEndpoint1() == vertex || edge.getEndpoint2() == vertex) {
                return edge;
            }
        }
        return null;
    }

    // Adds the specified Edge edge to the collection of Edges incident to this Vertex.
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    // Removes this Edge from the collection of Edges incident to this Vertex. 
    // Returns true if this Edge was connected to this Vertex, otherwise returns false.
    public boolean removeEdge(Edge edge) {
        return edges.remove(edge);
    }

    // Returns a collection of all the Vertices adjacent to this Vertex.
    // The return type of this method is unimportant - it just needs to be something that is Iterable.
    public Iterable<Vertex> adjacentVertices() {
        List<Vertex> adjacentVertices = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getEndpoint1() != this) {
                adjacentVertices.add(edge.getEndpoint1());
            }
            if (edge.getEndpoint2() != this) {
                adjacentVertices.add(edge.getEndpoint2());
            }
        }
        return adjacentVertices;
    }

    // Returns a collection of all the Edges incident to this Vertex.
    // The return type of this method is unimportant - it just needs to be something that is Iterable.
    public Iterable<Edge> incidentEdges() {
        return edges;
    }

}