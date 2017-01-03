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
    static Random rn=new Random();
 static double total_Dynamic_power=0;
static double average_total_power=0; 
    public static void testProgram(int n) {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Node location = new Node("Node_" + i, "Node_" + i);
            nodes.add(location);
        }
        Node arr[]=new Node[n];
        for(int i=0;i<arr.length;i++){
        arr[i]=nodes.get(i);
        }
        int n1=0; int m=0;
        for(int i=0;i<arr.length;i++){
            n1=rn.nextInt(10-5)+1;
            m=rn.nextInt(70)+10;
        arr[i].setLocation(n1, m);
        }
      /*  Node a = nodes.get(2);
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
        g.setLocation(2, 30);*/

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                makeEdges("Edge" + (i + j), nodes.get(i), nodes.get(j));
            }
        }
        
        Graph graph = new Graph(nodes, edges);
        Message msg1[]=new Message[1000];
       route = new BestRoute(graph);

        for(int i=0;i<1000;i++){
            int o=rn.nextInt(n);
            int h=rn.nextInt(n);
            while(o==h){
             o=rn.nextInt(n);
            h=rn.nextInt(n);
            }
       msg1[i]=new Message(o,h,0);
       average_total_power+=total_Dynamic_power;
       send(o,h,msg1[i]);
        }
        
        //Message msg=new Message(0,3,0);
        //route = new BestRoute(graph);
       // send(0,3,msg);
        
System.out.println("Average total power of 1000 Messages "+(average_total_power/1000)*100+" % ");
    }

    public static void send(int sender_id, int receiver_id,Message msg) {
        
        route.execute(nodes.get(sender_id));
        total_Dynamic_power=0;
        LinkedList<Node> path = route.getPath(nodes.get(receiver_id));
        if (path == null) {
              System.out.println(" Destination can not be reached from given source");
        } else {
            for (int i = 0; i < path.size(); i++) {
                System.out.println(path.get(i));
                msg.power_consumption++;
                System.out.println("distance between two nodes "+edges.get(i).getWeight());
              total_Dynamic_power += edges.get(i).getWeight()*0.05;
                
            }
            receive(receiver_id,msg);
        }
    }
    
    
        public static void receive(int receiver_id,Message msg) {
        
                System.out.println("Message was received    ");
                System.out.println(" Message Sender : "+ msg.sender_id+
                                    " ,Message Receiver : "+msg.receiver_id
                                     +" ,Power Consumed "+(msg.power_consumption-1) + ", Power when it is adjusted dynamically "+total_Dynamic_power);
           
    }

    public static void makeEdges(String edgeId, Node a, Node b) {
        int distance = (int) a.distance(b);
        if (distance <= 20) {
            Edge lane = new Edge(edgeId, a, b, distance);
            edges.add(lane);
        }
    }

}
