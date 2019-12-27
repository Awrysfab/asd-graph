package graph;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //DiGraph<String> g = DiGraph.readGraph("input.txt");
        DiGraph<String> g = DiGraph.readGraph("studi-kasus.txt");
//        g.readGraph("Input2.txt");
        System.out.println(g);
        System.out.println("Number of vertices: "
                + g.numberOfVertices());
        System.out.println("Number of edges: "
                + g.numberOfEdges());
        System.out.println("inDegree for A: "
                + g.inDegree("A"));
        System.out.println("outDegree for A: "
                + g.outDegree("A"));
        System.out.println("Weight e(A,B): "
                + g.getWeight("A", "B"));
        System.out.println(g.containsVertex("B"));

    }

}