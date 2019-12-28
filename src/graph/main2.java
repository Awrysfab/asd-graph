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
        DiGraph<String> g = DiGraph.readGraph();
        System.out.println(g);
    }
}