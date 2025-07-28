/*
 * Edge.java
 * Aum Desai
 * May 3rd
 * 
 * an edge object that connects vertices
 * 
 */

public class Edge {

    // The two endpoints of this edge and its distance
    private Vertex endpoint1, endpoint2;
    private double distance;

    // Constructor that constructs an Edge consisting of the two vertices with a distance of the given distance.
    public Edge(Vertex u, Vertex v, double distance) {
        this.endpoint1 = u;
        this.endpoint2 = v;
        this.distance = distance;
    }

    // Returns the distance of this edge.
    public double distance() {
        return distance;
    }

    // If vertex is one of the endpoints of this edge, returns the other endpoint.
    // Otherwise returns null.
    public Vertex other(Vertex vertex) {
        if (endpoint1 == vertex) {
            return endpoint2;
        } else if (endpoint2 == vertex) {
            return endpoint1;
        } else {
            return null;
        }
    }

    // Returns an array of the two Vertices comprising this Edge. Order is arbitrary.
    public Vertex[] vertices() {
        Vertex[] vertices = new Vertex[2];
        vertices[0] = endpoint1;
        vertices[1] = endpoint2;
        return vertices;
    }

    // get the first endpoint
    public Vertex getEndpoint1() {
        return this.endpoint1;
    }

    // get the 2nd endpoint
    public Vertex getEndpoint2() {
        return this.endpoint2;
    }

    // check if a vertex has any endpoint
    public boolean hasEndpoint(Vertex v) {
        if (v == this.endpoint1 || v == this.endpoint2){
            return true;
        }
        return false;
    }
}

