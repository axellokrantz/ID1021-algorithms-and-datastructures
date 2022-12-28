public class Paths {

    City[] path;
    int sp;

    public Paths() {
        path = new City[54];
        sp = 0;
    }

    public Integer shortest (City from, City to, Integer max){
        
        if(max < 0)
            return null;
        if(from == to)
            return 0;
    
        Integer shortest = null;
        for (int i = 0; i < sp; i++){
            if (path[i] == from)
                return null;
        }
        Integer totalDistance, distance;
 
        path[sp++] = from;
        for (int i = 0; i < from.connections.length; i++){
            
            if (from.connections[i] != null) {
            
            Connections connection = from.connections[i];
            distance = shortest(connection.city, to, max - connection.distance);
                // path is correct, did not exceed max value.
                if(distance != null){
                    totalDistance = distance + connection.distance;
                    if (shortest == null || totalDistance < shortest)
                        shortest = totalDistance;
                }
            }
        }
        path[sp--] = null;
        return shortest;
    }

    public static void main(String[] args) {
        
        Map map = new Map("trains.csv");
        Paths paths = new Paths();

        long t0 = System.nanoTime();
        Integer dist = paths.shortest(map.lookUp("Malmö"), map.lookUp("Kiruna"), 10_000);
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shorest: " + dist + " min (" + time + " ms)");
    }
}