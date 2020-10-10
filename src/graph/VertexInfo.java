
package graph;

import java.util.LinkedList;

public class VertexInfo<T> {

    public T vertex;
    public LinkedList<Edge> edgeList;

    public int inDegree;
    public int outDegree;

    public VertexInfo(T v) {
        vertex = v;
        edgeList = new LinkedList<Edge>();
        inDegree = 0;
        outDegree = 0;
    }

    VertexInfo() {
       
    }

    public boolean equals(Object obj) {
        VertexInfo<T> vertex2 = (VertexInfo<T>) obj;
        return this.vertex.equals(vertex2.vertex);
    }

    @Override
    public String toString() {
        return " VertexInfo{" + "vertex=" + vertex + ", edgeList=" + edgeList + ", inDegree=" + inDegree + ", outDegree=" + outDegree + "}\n";
    }

}
