import java.util.Random;

public class Search {

    public static void main(String[] args) {
        duplicatesBenchmark(1_000_000);
    }

    public static void duplicatesBenchmark(int n){
        int loop = 1000;
        long t_total = 0;

        int[] keys = new int[n];
        int[] array = new int[n];
        Random rnd = new Random();
        int nxt2;
        int nxt1;
        
        for (int l = 0; l < loop; l++){
            
            nxt2 = 0;
            nxt1 = 0;
    
            for (int j = 0; j < n; j++){
                nxt1 += rnd.nextInt(10) + 1;
                keys[j] = nxt1;
                nxt2 += rnd.nextInt(10) + 1;
                array[j] = nxt2;
            }
    
            for(int i = 0; i < keys.length; i++){
                long t0 = System.nanoTime();
                binarySearch(array, keys[i]);
                t_total += (System.nanoTime() - t0);
            }
        }        

        System.out.println("Time elapsed: " + (double)t_total/(double)loop + "ns");
    }

    public static void benchmarkUnsorted (int n){
        int loop = 1_000_000;
        Random rnd = new Random();
        long t_access = 0;
        int unsortedArray[] = new int[n];

        for(int i = 0; i < loop; i++){
            for (int j = 0; j < unsortedArray.length; j++)
                unsortedArray[j] = rnd.nextInt(n/10);
            int key = rnd.nextInt(n/10);

            long t0 = System.nanoTime();
            search(unsortedArray, key);
            t_access += System.nanoTime() - t0;
        }
        System.out.println(((double)(t_access)/(double)loop));
    }

    public static void benchmarkSorted (int n){

        int loop = 1_000_000;
        int sortedArray[] = new int[n];
        long t_access = 0;
        Random rnd = new Random();

        for(int i = 0; i < loop; i++){
            int key = rnd.nextInt(n/10);
            int nxt = 0;
            for (int j = 0; j < sortedArray.length; j++){
                nxt += rnd.nextInt(10) + 1;
                sortedArray[j] = nxt;
            }
            long t0 = System.nanoTime();
            searchSorted(sortedArray, key);
            t_access += System.nanoTime() - t0;
        }
        System.out.println(((double)(t_access)/(double)loop));
    }

    public static void searchSorted(int[] array, int key){
        for(int index = 0; index < array.length; index++){
            if (array[index] == key || key < array[index]){
                break;
            }
        }
    }

    public static void search(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                break;
            }
        }
    }        

    public static boolean binarySearch(int[] array, int key) {

        int first = 0;
        int last = array.length-1;
        while (true) {
        
        int mid = first + (last - first)/2;

        if (array[mid] == key) {
            return true;
        }
        if (array[mid] < key && mid < last){
        first = mid + 1;
        continue;
        }
        if (array[mid] > key && mid > first){
        last = mid - 1;
        continue;
        }
        return false;
        }
    }

    public static void benchmarkBinarySearch(int n){

        int loop = 1_000_000;
        int sortedArray[] = new int[n];
        long t_access = 0;
        Random rnd = new Random();

        for(int i = 0; i < loop; i++){
            int nxt = 0;
            for (int j = 0; j < sortedArray.length; j++){
                nxt += rnd.nextInt(10) + 1;
                sortedArray[j] = nxt;
            }
            int key = rnd.nextInt(n/10);
            long t0 = System.nanoTime();
            binarySearch(sortedArray, key);
            t_access += System.nanoTime() - t0;
        }
        System.out.print("Time elpsed: " + ((double)(t_access)/(double)loop));
    }

    public static void evenBetterDuplicateSearchAlgorithm(int n){
        Random rnd = new Random();

        int[] first = new int[n];
        int nxt = 0;
        int nxt2 = 0;
        int[] second = new int[n];
        long t_total = 0;
        int sum = 0;

        for (int rounds = 0; rounds < 1000; rounds++) {

            for (int i = 0; i < n; i++) {
                nxt += rnd.nextInt(10) + 1;
                first[i] = nxt;
                nxt2 += rnd.nextInt(10) + 1;
                second[i] = nxt2;
            }

            long t0 = System.nanoTime();
            for (int i = 0, j = 0; i < n && j < n;) {
                if (first[i] < second[j]) {
                    i++;
                    continue;
                } else if (first[i] > second[j]) {
                    j++;
                }
                else if (first[i] == second[j]){
                    i++;
                    sum++;
                }
            }
            t_total += System.nanoTime() - t0;
        }

        System.out.println("Average time elapsed: " + (double)t_total/(double)1000);
    }
}
