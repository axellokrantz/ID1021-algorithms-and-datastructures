import java.util.Random;

public class Program {
    public static void main(String[] args) {
        
        // benchmarkArray(10);
        // benchmarkArray(100);
        // benchmarkArray(1000);
        // benchmarkArray(10_000);
        // benchmarkArray(100_000);
        // benchmarkArray(1_000_000);

        // SinglyQuickSort sq = new SinglyQuickSort();
        // sq.addNode(1);
        // sq.addNode(9);
        // sq.addNode(5);

        // SinglyQuickSort.Node n = sq.head;
        // while (n.next != null)
        //     n = n.next;

        // System.out.println("Linked List before sorting");
        // sq.display();

        // sq.sort(sq.head, n);
 
        // System.out.println("\nLinked List after sorting");
        // sq.display();
        
        benchmarkArray(10);
        benchmarkArray(100);
        benchmarkArray(1000);
        benchmarkArray(10_000);
        benchmarkArray(100_000);
        benchmarkArray(1_000_000);
        // 134 898 331

    }

    private static void benchmarkArray(int n){

        int loop = 1000;
        long t_total = 0;
        int array[] = new int[n];
        Random rnd = new Random();

        for(int i = 0; i < loop; i++){

            for(int j = 0; j < n; j++){
                array[j] = rnd.nextInt(n);
            }

            long t0 = System.nanoTime();
            ArrayQuickSort.sortArray(array);
            t_total += System.nanoTime() - t0;
        }
        System.out.println("n " + n + ": " + (double)t_total/(double)loop + "ns");
    }
}
