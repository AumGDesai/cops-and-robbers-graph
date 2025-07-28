/*
 * MoveTowardPlayerAlgorithm.java
 * Aum Desai
 * May 3rd
 * 
 * Chaser player algorithm
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoveTowardPlayerAlgorithm extends AbstractPlayerAlgorithm {
    private Vertex otherPlayer;
    
    // constructor
    public MoveTowardPlayerAlgorithm(Graph graph) {
        super(graph);
    }

    // choose the starting place
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

    // choose the starting place, avoid collision with other
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

    // choose the next place to move to 
    public Vertex chooseNext(Vertex otherPlayer) {
        double minDistance = Double.MAX_VALUE;
        Vertex nextVertex = getCurrentVertex();

        for (Vertex v : getCurrentVertex().adjacentVertices()) {
            
            double distance = graph.getDistance(v, otherPlayer);
            if (distance < minDistance) {
                minDistance = distance;
                nextVertex = v;
            }
            
        }
        setCurrentVertex(nextVertex);
        
        return nextVertex;
    }

    // choose the next vertex to move to, avoid collision w/ partner
    public Vertex chooseNext(Vertex otherPlayer, Vertex partner){
        double minDistance = Double.MAX_VALUE;
        Vertex nextVertex = getCurrentVertex();

        for (Vertex v : getCurrentVertex().adjacentVertices()) {
            if (v != partner){
                double distance = graph.getDistance(v, otherPlayer);
                if (distance < minDistance) {
                    minDistance = distance;
                    nextVertex = v;
                }

            }        
            
        }
        setCurrentVertex(nextVertex);
        
        return nextVertex;
    }

}
    




