/*
 * MoveAwayPlayerAlgorithm.java
 * Aum Desai
 * May 3rd
 * 
 * Make evader player algorithm
 * 
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoveAwayPlayerAlgorithm extends AbstractPlayerAlgorithm {
    private Vertex otherPlayer;
    
    public MoveAwayPlayerAlgorithm(Graph graph) {
        super(graph);
    }

    public Vertex chooseStart() {
        List<Vertex> vertices = new ArrayList<>();
        for (Vertex v : graph.getVertices()) {
            vertices.add(v);
        }
        int index = (int) (Math.random() * vertices.size());
        Vertex startVertex = vertices.get(index);
        setCurrentVertex(startVertex);
        return startVertex;
    }

    public Vertex chooseStart(Vertex other) {
        List<Vertex> vertices = new ArrayList<>();
        for (Vertex v : graph.getVertices()) {
            if (v != other){
                vertices.add(v);
            }
        }
        int index = (int) (Math.random() * vertices.size());
        Vertex startVertex = vertices.get(index);
        setCurrentVertex(startVertex);
        return startVertex;
    }

    public Vertex chooseNext(Vertex otherPlayer) {
        double maxDistance = Double.MIN_VALUE;
        Vertex nextVertex = getCurrentVertex();

        for (Vertex v : getCurrentVertex().adjacentVertices()) {
            
            double distance = graph.getDistance(v, otherPlayer);
            if (distance > maxDistance) {
                maxDistance = distance;
                nextVertex = v;
            }
            
        }
        setCurrentVertex(nextVertex);
        
        return nextVertex;
    }

    @Override
    public Vertex chooseNext(Vertex otherPlayer, Vertex partner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chooseNext'");
    }
    
}



