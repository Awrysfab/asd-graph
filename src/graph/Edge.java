
package graph;

class Edge {

    public int dest;
    public int weight;

    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public boolean equals(Object obj) {
          return ((Edge)obj).dest == this.dest;    
    }

    @Override
    public String toString() {
        return "Edge{" + "dest=" + dest + ", weight=" + weight + '}';
    }
    
}
