/*
 * AbstractPlayerAlgorithm.java
 * Aum Desai
 * May 3rd
 * 
 * Abstract class for player algorithm
 * 
 */


import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public abstract class AbstractPlayerAlgorithm {
    protected Graph graph; // the underlying graph of the game
    private Vertex currentVertex; // the current vertex of the player
    
    public AbstractPlayerAlgorithm(Graph graph) {
        this.graph = graph;
    }
    
    // returns the underlying graph
    public Graph getGraph() {
        return this.graph;
    }
    
    // returns the current vertex of the player
    public Vertex getCurrentVertex() {
        return this.currentVertex;
    }
    
    // sets the current vertex of the player
    public void setCurrentVertex(Vertex vertex) {
        this.currentVertex = vertex;
    }
    
    // abstract method that returns the starting vertex for the player
    public abstract Vertex chooseStart();
    
    // abstract method that returns the starting vertex for the player
    // based on where the other player started
    public abstract Vertex chooseStart(Vertex other);
    
    // abstract method that returns the next vertex for the player to move to
    // based on where the other player is currently located
    public abstract Vertex chooseNext(Vertex otherPlayer);


    public abstract Vertex chooseNext(Vertex otherPlayer, Vertex partner);


    // protected Edge getRandomEdge(Vertex v) {
    //     boolean vExists = false;
    //     for (Vertex vertex : graph.getVertices()) {
    //         if (vertex.equals(v)) {
    //             vExists = true;
    //             break;
    //         }
    //     }
    //     if (!vExists) {
    //         return null;
    //     }

    //     ArrayList<Edge> edgesList = new ArrayList<>();
    //     for (Edge edge : graph.getEdges()) {
    //         if (edge.hasEndpoint(v)) {
    //             edgesList.add(edge);
    //         }
    //     }

    //     if (edgesList.isEmpty()) {
    //         return null;
    //     }

    //     Random random = new Random();
    //     int randomIndex = random.nextInt(edgesList.size());
    //     return edgesList.get(randomIndex);
    // }

    

}
