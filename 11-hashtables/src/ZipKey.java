import java.io.BufferedReader;
import java.io.FileReader;

public class ZipKey {

    Node[] data;
    int max;

    public class Node {
        Integer code;
        String name;
        Integer population;

        Node(Integer code, String name, Integer population){
            this.code = code;
            this.name = name;
            this.population = population;
        }

        public String print(){
            return code + " " + name + population.toString();
        }
    }

    public ZipKey(String file) {
        data = new Node[100_000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
            } catch (Exception e) {
                System.out.println(" file " + file + " not found");
            }
        }
    
    public void linearSearch(Integer entry){
        if(data[entry] != null){
            System.out.println("Found! " + data[entry].name);
        }
    }

    public void binarySearch(Integer entry){
        int max = this.data.length - 1;
        int min = 0;
        binarySearch(entry, max, min);
    }

    public boolean binarySearch(Integer entry, int max, int min){
        
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
