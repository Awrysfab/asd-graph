package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;

public class DiGraph<T> implements Graph<T> {

    static DiGraph<String> graph = new DiGraph<String>();
    ArrayList<VertexInfo<T>> vInfo;
    HashMap<T, Integer> vtxMap;

    //VertexInfo<Integer> v=new VertexInfo<Integer>();
    public DiGraph() {
        vInfo = new ArrayList<VertexInfo<T>>();
        vtxMap = new HashMap<T, Integer>();
    }

    public static DiGraph<String> readGraph() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Jumlah vertex: ");
        int nVtx = scan.nextInt();
        for (int j = 0; j <= nVtx; j++) {
            graph.addVertex(scan.nextLine());
        }
        return graph;
    }
    
    
    public static DiGraph<String> readGraph(String fileName) throws FileNotFoundException, IOException {
        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int i = 0;
        int n = 0, nEdge = 0;
        while ((st = br.readLine()) != null) {
            if (st == null) {
                break;
            }
            if (i == 0) {
                System.out.println(st);
                n = st.charAt(0) - '0';
//                n = Integer.parseUnsignedInt(st);
                i++;
            } else if (i == 1) {
                String[] h = st.split(" ");
                for (int j = 0; j < n; j++) {
                    //VertexInfo<String> v = new VertexInfo<String>(h[j]);
                    graph.addVertex(h[j]);
                }
                i++;
            } else if (i == 2) {
                nEdge = st.charAt(0) - '0';
                i++;
            } else if (i == 3) {
                String[] h = st.split(" ");
                graph.addEdge(h[0], h[1], Integer.parseInt(h[2]));
            }
//            System.out.println(st);
        }
        return graph;
    }

    @Override
    public boolean addEdge(T v1, T v2, int w) {
        int pos1 = -1, pos2 = -1, numEdges = 0;
        pos1 = getVInfoIndex(v1);
        pos2 = getVInfoIndex(v2);
        
// get VertexInfo objects for vertices v1 and v2
        VertexInfo<T> vtxInfo1 = vInfo.get(pos1),
                vtxInfo2 = vInfo.get(pos2);
        Edge e = new Edge(pos2, w);
        boolean returnValue = true;

        if (!vtxInfo1.edgeList.contains(e)) {
            vtxInfo1.edgeList.add(e);
            vtxInfo1.outDegree++;
            // increment inDegree for vertex v2 and number of edges
            vtxInfo2.inDegree++;
            numEdges++;
        } else {
            returnValue = false;
        }
        return returnValue;
    }

    private int getVInfoIndex(Object v) {
        // get the Integer value field of the vtxMap entry
        Integer indexObj = vtxMap.get(v);

        // if value is null, there is not entry in
        // the map; return -1; otherwise, convert
        // object to an int
        if (indexObj == null) {
            return -1;
        } else {
            return indexObj;
        }
    }

    @Override
    public boolean addVertex(T v) {
        if (!vtxMap.containsKey(v)) {
            vtxMap.put(v, vInfo.size());
            vInfo.add(new VertexInfo(v));
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        vInfo.clear();
        vtxMap.clear();
    }

    @Override
    public boolean containsEdge(T v1, T v2) {
        /*int index1 = -1, index2 = -1;
        if (vtxMap.containsKey(v1)) {
            index1 = vtxMap.get(v1);
        }
        //System.out.println("TTTT = " + index1);
        if (vtxMap.containsKey(v2)) {
            index2 = vtxMap.get(v2);
        }
        //System.out.println("TTTT = " + index2);
        if (index1 == -1 || index2 == -1) {
            throw new IllegalArgumentException("Index tidak ada");
        }
        if (index1 != -1) {
            if (vInfo.get(index1).edgeList.contains(new Edge(index2, 10))) {
                return true;
            }
        }
        return false;*/
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsVertex(Object v) {
        //return vInfo.contains(v);
        return vtxMap.containsKey(v);
    }

    @Override
    public Set<T> getNeighbors(T v) {
        // find the VertexInfo object for index v
        int index = getVInfoIndex(v);

        // check for an error and throw exception
        // if vertices not in graph
        if (index == -1) {
            throw new IllegalArgumentException("DiGraph getNeighbors(): vertex not in graph");
        }
        HashSet<T> edgeSet = new HashSet<T>();
        VertexInfo<T> vtxInfo = vInfo.get(index);
        Iterator<Edge> iter = vtxInfo.edgeList.iterator();
        Edge e = null;

        while (iter.hasNext()) {
            e = iter.next();
            edgeSet.add(vInfo.get(e.dest).vertex);
        }

        return edgeSet;

    }

    @Override
    public int getWeight(T v1, T v2) {
        int index1 = vtxMap.get(v1);
        int index2 = vtxMap.get(v2);
        VertexInfo<T> vertex = vInfo.get(index1);
        for (int i = 0; i < vertex.edgeList.size(); i++) {
            Edge e = vertex.edgeList.get(i);
            if(e.dest == index2){
                return e.weight;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return vInfo.size() == 0;
    }

    @Override
    public int numberOfEdges() {
        int n = 0;
        ListIterator it = vInfo.listIterator();

        while (it.hasNext()) {
            VertexInfo<T> v = (VertexInfo<T>) it.next();
            n = n + v.edgeList.size();
        }
        return n;

    }

    @Override
    public int numberOfVertices() {
        return vInfo.size();
    }

    @Override
    public boolean removeEdge(T v1, T v2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int setWeight(T v1, T v2, int w) {
     int pos1 = -1, pos2 = -1, numEdges = 0;
        pos1 = getVInfoIndex(v1);
        pos2 = getVInfoIndex(v2);
        
// get VertexInfo objects for vertices v1 and v2
        VertexInfo<T> vtxInfo1 = vInfo.get(pos1),
                vtxInfo2 = vInfo.get(pos2);
        Edge e = new Edge(pos2, w);
        boolean returnValue = true;

        for(int i=0;i<vtxInfo1.edgeList.size();i++){
            Edge temp = vtxInfo1.edgeList.get(i);
            if(temp.dest==pos2){
                vtxInfo1.edgeList.set(i, e);
                break;
            }
        }
        return 1;   
    }

    @Override
    public Set<T> vertexSet() {
        Set<T> s = vtxMap.keySet();
        return s;
    }

    @Override
    public String toString() {
        return "DiGraph{" + "vInfo=" + vInfo + '}';
    }

    public int inDegree(T v) {
        int index = vtxMap.get(v);
        VertexInfo<T> vertex = vInfo.get(index);
        return vertex.inDegree;
    }

    public int outDegree(T v) {
        int index = vtxMap.get(v);
        VertexInfo<T> vertex = vInfo.get(index);
        return vertex.outDegree;
    }

}
