
package project;


public class Edge  {
        private final String id;
        private final Node source;
        private final Node destination;
        private int distance;

        public Edge(String id, Node source, Node destination, int distance) {
                this.id = id;
                this.source = source;
                this.destination = destination;
                this.distance = distance;
        }

              public Edge(String id, Node source, Node destination) {
                this.id = id;
                this.source = source;
                this.destination = destination;
                this.distance = 0;
        }
        public String getId() {
                return id;
        }
        public Node getDestination() {
                return destination;
        }

        public Node getSource() {
                return source;
        }
        public int getWeight() {
                return distance;
        }
        
            public void setWeight(int w) {
                this.distance=w;
        }

        @Override
        public String toString() {
                return source + " " + destination;
        }


}