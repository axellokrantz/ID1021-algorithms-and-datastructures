import java.io.BufferedReader;
import java.io.FileReader;

public class Map {

    private final int mod = 541;
    private City[] cities;
    
    public Map(String file) {
    cities = new City[mod];
    try (BufferedReader br = new BufferedReader(new FileReader(file))){
    String line;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            
            addCities(row[0], row[1], row[2]);

        }
        } catch (Exception e){
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    private Integer hash (String name){
    int hash = 7;
    for (int i = 0; i < name.length(); i++) {
        hash = (hash*31 % mod) + name.charAt(i);
    }
        return hash % mod;
    }

    public City lookUp (String name){
        Integer index = hash(name);
        if(cities[index] != null){
            City current = cities[index];
            while(current != null){
                if(current.name.equals(name)){
                    return current;
                }
                current = current.next;
            }
        }
        return null;
    }

    private void insert(City city){
        Integer index = hash(city.name);

        if(cities[index] == null)
            cities[index] = city;
        else{
            City current = cities[index];
    
            while(current.next != null)
                current = current.next;
    
            current.next = city;
        }
    }

    private City addCity(String name){
        City lookUp = lookUp(name);
        if(lookUp == null){
            lookUp = new City(name);
            insert(lookUp);
        }
        return lookUp;
    }
    private void addCities(String cityString, String destinationString, String distanceString){
        
        City city = addCity(cityString);
        City destination = addCity(destinationString);
        Integer distance = Integer.valueOf(distanceString);
        city.addConnection(destination, distance);
        destination.addConnection(city, distance);
        
    }
}
