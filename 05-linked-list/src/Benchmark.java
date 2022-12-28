import java.util.Random;

public class Benchmark {
    
    public static void benchmarkAppendAfter(int size){

        Random rnd = new Random();
        long t_total = 0;
        int loop = 10_000;
    
        for(int i = 0; i < loop; i++){

            LinkedList a = new LinkedList();
            LinkedList b = new LinkedList();

            // Lägg till så att b får lite fler värden.
            b.addNode(1);

            for (int j = 0; j < size; j++){
                a.addNode(rnd.nextInt(100));
            }
            
            long t0 = System.nanoTime();
            b.appendAfter(a);
            t_total += System.nanoTime() - t0;
        }
        System.out.println("Time it took:" + (double)t_total/loop + " ns");
    }

    public static void benchmarkAppendBefore(int size){
        Random rnd = new Random();
        long t_total = 0;
        int loop = 100;
    
        for(int i = 0; i < loop; i++){

            LinkedList a = new LinkedList();
            LinkedList b = new LinkedList();

            // Lägg till så att b får lite fler värden.
            b.addNode(1);

            for (int j = 0; j < size; j++){
                a.addNode(rnd.nextInt(100));
            }
            
            long t0 = System.nanoTime();
            b.appendBefore(a);
            t_total += System.nanoTime() - t0;
        }
        System.out.println("Time it took:" + (double)t_total/loop + " ns");
    }

    public static int[] arrayAppend(int[] array1, int[] array2){

        int arraySize = array1.length + array2.length;
        int[] newArray = new int[arraySize];
        int j = 0;

        for(int i = 0; i < array1.length; i++){
            newArray[j] = array1[i];
            j++;
        }
        for(int i = 0; i < array2.length; i++){
            newArray[j] = array2[i];
            j++;
        }

        return newArray;
    }

    public static void benchmarkArrayAppend(int size){
        long t_total = 0;
        int loop = 10_000;

        for(int i = 0; i < loop; i++){

            int[] fixed = new int[] {1,2,3,4,5,6,7,8,9,10};
            int[] dynamic = new int[size];

            for(int j = 0; j < size; j++){
                dynamic[j] = fixed.length + j + 1;
            }

            long t0 = System.nanoTime();
            arrayAppend(fixed, dynamic);
            t_total += System.nanoTime() - t0;
        }
        System.out.println("Time it took:" + (double)t_total/loop + " ns");
    
    }

    public static void benchmarkAddAppend(int addOperations){
        int loop = 1000;
        long t_total = 0;
        for (int i = 0; i < loop; i++){
            LinkedList list = new LinkedList();

            for (int j = 0; j < addOperations; j++){

                long t0 = System.nanoTime();
                list.addNode(1);
                t_total += System.nanoTime() - t0;
            }
        }
            System.out.println("Time it took:" + (double)t_total/(double)loop + " ns");
    }
}
