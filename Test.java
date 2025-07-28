/*
 * Test.java
 * Aum Desai
 * May 3rd
 * 
 * Testing Edge, Vertex and Vraph
 * 
 */

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

        // general setup 
        Graph g = new Graph();
        Vertex[] vertices = new Vertex[7];
        for (int i = 0; i < 7; i++) {
            vertices[i] = g.addVertex();
        }
        for (int i = 0; i < 7; i++) {
            g.addEdge(vertices[i], vertices[(i + 1) % 7], 1);
        }
    
        // this can implicityly test "addEdge" method
        g.addEdge(vertices[0], vertices[2], 1);
        g.addEdge(vertices[0], vertices[3], 2);
        g.addEdge(vertices[3], vertices[6], 3);
        g.addEdge(vertices[4], vertices[6], 4);
    
        // Iterable<Edge> eList = g.getEdges();   // implicitly checking iterable functionality here
        // Iterable<Vertex> vList = g.getVertices(); // implicitly checking iterable functionality here
    
        // test 1: check that all vertices have been added to the graph
        {
            assert g.size() == 7 : "Test 1 failed: vertex count is incorrect";
        }

    
        // test 2: check that the weight of edge (0, 2) is 1
        {
            Vertex v1 = vertices[0];
            Vertex v2 = vertices[2];
            Edge e = v1.getEdgeTo(v2);
            assert e.distance() == 1 : "Test 2 failed: edge weight is incorrect";
        }
    
        // test 3: check that the distance of edge (0, 3) is 2
        {
            Vertex v1 = vertices[0];
            Vertex v2 = vertices[3];
            Edge e = v1.getEdgeTo(v2);
            assert e.distance() == 2 : "Test 3 failed: edge weight is incorrect";
        }

        // test 4: distance from
        {
            Vertex v1 = vertices[0];
            Vertex v2 = vertices[3];
            HashMap<Vertex, Double> v1Dis= g.distanceFrom(v1);
            System.out.println(v1Dis.toString());

        }

        // test 5: get distance
        {
            Vertex v1 = vertices[0];
            Vertex v2 = vertices[3];
            assert g.getDistance(v1, v2) == 2: "Test 5 filed: getDistance is incorrect";

        }
    
    
        System.out.println("All tests passed!");
    }
    
    
}


