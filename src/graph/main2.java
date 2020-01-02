/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.io.IOException;

/**
 *
 * @author User
 */
public class main2 {
    public static void main(String[] args) throws IOException {
        DiGraph<String> g;
        g = DiGraph.readGraph("input.txt");
        //DiGraph<String> g = DiGraph.readGraph("D:\\javatest\\a\\studi-kasus.txt");
        g.readGraph("Input2.txt");
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