public class City {
    String name;
    Connections[] connections;
    City next;

    public City (String name) {
        this.name = name;
        this.next = null;
        connections = new Connections[5];
    }

    public void addConnection(City cityDestination, Integer distance){
        int i = 0;
        while(connections[i] != null){
            i++;
        }
        connections[i] = new Connections (cityDestination, distance);
    }
}