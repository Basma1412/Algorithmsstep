package project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkingArea {

    static List<Vertex> nodes;
    static List<Edge> edges;

    public static void testExcute() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();

        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }
Vertex a=nodes.get(2);
Vertex b=nodes.get(6);

a.setLocation(1, 5);
b.setLocation(200,7);
       makeEdges("Edge_0", a, b);
//        addLane("Edge_1", 0, 2);
//        addLane("Edge_2", 0, 4);
//        addLane("Edge_3", 2, 6);
//        addLane("Edge_4", 2, 7);
//        addLane("Edge_5", 3, 7);
//        addLane("Edge_6", 5, 8);
//        addLane("Edge_7", 8, 9);
//        addLane("Edge_8", 7, 9);
//        addLane("Edge_9", 4, 9);
//        addLane("Edge_10", 9, 10);
//        addLane("Edge_11", 1, 10);

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        BestRoute dijkstra = new BestRoute(graph);
        dijkstra.execute(nodes.get(2));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(6));

        if (path==null)
        {
            
        }
        else
        {for (int i=0;i<path.size();i++) {
            System.out.println(path.get(i));
        }}

    }

    public static void makeEdges(String laneId, Vertex a, Vertex b) {
        int distance = (int) a.distance(b);
        if (distance <= 20) {
            Edge lane = new Edge(laneId, a, b, distance);
                  edges.add(lane);

        }
    }

    public static void addLane(String laneId, int sourceLocNo, int destLocNo) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo));
        edges.add(lane);
    }

}
