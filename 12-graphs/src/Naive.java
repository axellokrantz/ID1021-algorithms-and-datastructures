public class Naive {
    public static void main(String[] args) {
        
        Map map = new Map("trains.csv");

        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookUp("Stockholm"), map.lookUp("Umeå"), 550);
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shorest: " + dist + " min (" + time + " ms)");
    }
    
    private static Integer shortest(City from, City to, Integer max) {
        
        // if max is lower than 0 the method will return null.
        if (max < 0)
            return null;
        if (from == to)
            return 0;

        Integer shortest = null;
        Integer totalDistance, distance;
 
        
        for (int i = 0; i < from.connections.length; i++){
            
            if (from.connections[i] != null) {
            
            Connections connection = from.connections[i];
            distance = shortest(connection.city, to, max - connection.distance);
            
                // Make sure distance is not null.
                if(distance != null){
                    totalDistance = distance + connection.distance;
                    if (shortest == null || totalDistance < shortest)
                        shortest = totalDistance;
                }
            }
        }
        return shortest;
    }
}