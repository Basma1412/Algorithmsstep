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
        nodes = new ArrayList<>();
        edges = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }
        Vertex a = nodes.get(2);
        Vertex b = nodes.get(5);
        a.setLocation(1, 5);
        b.setLocation(200, 7);

        Vertex d = nodes.get(3);
        Vertex e = nodes.get(4);
        d.setLocation(2, 51);
        e.setLocation(2, 31);

        Vertex f = nodes.get(1);
        Vertex g = nodes.get(0);
        f.setLocation(1, 30);
        g.setLocation(2, 30);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == j) {
                    continue;
                }
                makeEdges("Edge" + (i + j), nodes.get(i), nodes.get(j));
            }
        }
        Graph graph = new Graph(nodes, edges);
        BestRoute dijkstra = new BestRoute(graph);
        dijkstra.execute(nodes.get(0));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(3));

        if (path == null) {

        } else {
            for (int i = 0; i < path.size(); i++) {
                System.out.println(path.get(i));
            }
        }

    }

    public static void makeEdges(String laneId, Vertex a, Vertex b) {
        int distance = (int) a.distance(b);
        if (distance <= 20) {
            Edge lane = new Edge(laneId, a, b, distance);
            edges.add(lane);

        }
    }



}
