
package graph;

import java.util.Set;


public interface Graph<T> {
    public boolean addEdge(T v1, T v2, int w);
    public boolean addVertex(T v);
    public void clear();
    public boolean containsEdge (T v1, T v2);
    public boolean containsVertex (Object v);
    public Set<T> getNeighbors(T v);
    public int getWeight (T v1, T v2);
    public boolean isEmpty();
    public int numberOfEdges();
    public int numberOfVertices();
    public boolean removeEdge(T v1, T v2);
    public int setWeight(T v1, T v2, int w);
    public Set<T> vertexSet();
    
}
    
