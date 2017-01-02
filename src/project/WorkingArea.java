package project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkingArea {

    static List<Node> nodes;
    static List<Edge> edges;
    static BestRoute route;

    public static void testProgram() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Node location = new Node("Node_" + i, "Node_" + i);
            nodes.add(location);
        }
        Node a = nodes.get(2);
        Node b = nodes.get(5);
        Node d = nodes.get(3);
        Node e = nodes.get(4);
        Node f = nodes.get(1);
        Node g = nodes.get(0);
        a.setLocation(1, 5);
        b.setLocation(200, 7);
        d.setLocation(2, 51);
        e.setLocation(2, 31);
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
        
        Message msg=new Message(0,3,0);
        route = new BestRoute(graph);
        send(0,3,msg);

    }

    public static void send(int sender_id, int receiver_id,Message msg) {
        route.execute(nodes.get(sender_id));
        LinkedList<Node> path = route.getPath(nodes.get(receiver_id));
        if (path == null) {
              System.out.println(" Destination can not be reached from given source");
        } else {
            for (int i = 0; i < path.size(); i++) {
                System.out.println(path.get(i));
                msg.power_consumption++;  
            }
            receive(receiver_id,msg);
        }
    }
    
    
        public static void receive(int receiver_id,Message msg) {
        
                System.out.println("Message was received    ");
                System.out.println(" Message Sender : "+ msg.sender_id+
                                    " ,Message Receiver : "+msg.receiver_id
                                     +" ,Power Consumed "+(msg.power_consumption-1));
           
    }

    public static void makeEdges(String edgeId, Node a, Node b) {
        int distance = (int) a.distance(b);
        if (distance <= 20) {
            Edge lane = new Edge(edgeId, a, b, distance);
            edges.add(lane);
        }
    }

}
