package project;

public class Node {

    final private String id;
    private String name;
    private Location position;

    public Node(String id, String name) {
        this.id = id;
        this.name = name;

    }

    public Node(String id, String name, Location loc) {
        this.id = id;
        this.name = name;
        this.position = loc;
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return this.position;
    }

    
    public void setLocation(int x,int y) {
         this.position=new Location(x,y);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Node other = (Node) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    public double distance(Node mobile) {
        int locX = this.position.getX();
        int locY = this.position.getY();

        int locX2 = mobile.position.getX();
        int locY2 = mobile.position.getY();

        double distance;

        int param1 = locX2 - locX;
        int param2 = locY2 - locY;

        distance = Math.sqrt((Math.pow(param1, 2)) + (Math.pow(param2, 2)));

        return distance;

    }

}
