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
        DiGraph<String> g = DiGraph.readGraph("input.txt");
        //g.readGraph("Input2.txt");
        System.out.println(g);
        System.out.println(g.getNeighbors("B"));
        //g.setWeight("A", "B", 10);
        System.out.println(g.vertexSet());
        g.clear();
        System.out.println(g);
        
    }
}