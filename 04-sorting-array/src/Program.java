import java.util.Random;

public class Program {

  public static void main(String[] args) {

        benchmarkMergeSort(128);     
    }   
    
    static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void benchmarkInsertionSort(int n){
        
        int loop = 10_000;
        long t_total = 0;

        int[] array = new int[n];
        Random rnd = new Random();
        
        for(int j = 0; j < loop; j++){

            for(int i = 0; i < n; i++){
                array[i] = rnd.nextInt(10) + 1;
            }
            long t0 = System.nanoTime();
            InsertionSort.sort(array);
            t_total += System.nanoTime() - t0;
        }
        System.out.println("Selection sort benchmark: " + (double)t_total/(double)loop + " ns");
    }

    static void benchmarkSelectionSort(int n){
        
        int loop = 1000;
        long t_total = 0;

        int[] array = new int[n];
        Random rnd = new Random();
        
        for(int j = 0; j < loop; j++){

            for(int i = 0; i < n; i++){
                array[i] = rnd.nextInt(10) + 1;
            }
            long t0 = System.nanoTime();
            SelectionSort.sort(array);
            t_total += System.nanoTime() - t0;
        }
        System.out.println("Selection sort benchmark: " + (double)t_total/(double)loop + " ns");
    }

    static void benchmarkMergeSort(int n){
        int loop = 100_000;
        long t_total = 0;

        int[] array = new int[n];
        Random rnd = new Random();
        
        for(int j = 0; j < loop; j++){

            for(int i = 0; i < n; i++){
                array[i] = rnd.nextInt(10) + 1;
            }
            long t0 = System.nanoTime();
            MergeSort.sort(array);
            t_total += System.nanoTime() - t0;
        }
        System.out.println("Merge sort benchmark: " + (double)t_total/(double)loop + " ns");
    }
}
