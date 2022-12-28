import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {

    Node[] data;
    int max;

    public class Node {
        String code;
        String name;
        Integer population;

        Node(String code, String name, Integer population){
            this.code = code;
            this.name = name;
            this.population = population;
        }

        public String print(){
            return code + " " + name + population.toString();
        }
    }

    public Zip(String file) {
        data = new Node[9675];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
            } catch (Exception e) {
                System.out.println(" file " + file + " not found");
            }
        }
    
    public void linearSearch(String entry){

        for (int i = 0; i < data.length; i++) {
            if (entry.equals(data[i].code)){
                return;
            }
        }
    }

    public boolean binarySearch(String entry){
        
        int max = this.data.length - 1;
        int min = 0;
        
        while(true){
            int mid = min + (max - min) / 2;

            if(data[mid].code.equals(entry)){
                return true;
            }
            if(entry.compareTo(data[mid].code) > 0 && mid < max){
                min = mid + 1;
                continue;
            }
            if(entry.compareTo(data[mid].code) < 0 && mid > min){
                max = mid - 1;
                continue;
            }
            return false;
        }
    }
}
