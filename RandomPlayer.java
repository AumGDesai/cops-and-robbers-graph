/*
 * RandomPlayer.java
 * Aum Desai
 * May 3rd
 * 
 * Random player algorithm
 * 
 */

import java.util.ArrayList;
import java.util.Random;

public class RandomPlayer extends AbstractPlayerAlgorithm {
    private Random random;

    public RandomPlayer(Graph graph) {
        super(graph);
        this.random = new Random();
    }

    //choose a random vertex from the graph as a start index
    public Vertex chooseStart() {
        // Choose a random vertex from the graph
        Iterable<Vertex> vertices = this.getGraph().getVertices();
        int randomIndex = this.random.nextInt(((Graph) vertices).size());
        Vertex randomVertex = ((ArrayList<Vertex>) vertices).get(randomIndex);
        this.setCurrentVertex(randomVertex);
        return randomVertex;
    }

    // choose a starting place 
    public Vertex chooseStart(Vertex other) {
        // Choose a random vertex from the graph that is not the same as the other player's starting vertex
        ArrayList <Vertex> availableVertices = new ArrayList<>();
        for (Vertex vertex : graph.getVertices()) {
            if (!vertex.equals(other)) {
                availableVertices.add(vertex);
            }
        }
        Vertex startVertex = availableVertices.get(random.nextInt(availableVertices.size()));
        setCurrentVertex(startVertex);
        return startVertex;
    }
    
    // choose the next vertex to move to 
    public Vertex chooseNext(Vertex otherPlayer) {
        Iterable <Vertex> neighbor = otherPlayer.adjacentVertices();
        int randomIndex = this.random.nextInt(((Graph) neighbor).size());
        Vertex randomVertex = ((ArrayList<Vertex>) neighbor).get(randomIndex);
        this.setCurrentVertex(randomVertex);
        return randomVertex;
    }

    // choose the next vertex to move to and avoid collision with the partner vertex
    @Override
    public Vertex chooseNext(Vertex otherPlayer, Vertex partner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chooseNext'");
    }
    
}
