import java.util.Random;

class Program{
    public static void main(String[] args) {

        /* TreeHeap t = new TreeHeap();
        t.add(5, 5);
        t.add(4,4);
        t.add(2, 2);
        t.add(8, 8);

        t.push(100);
    

        for (int i : t)
            System.out.println("next priority: " + i); */

      benchmarkPriorityAdd(100000);
      benchmarkPriorityRemove(100000);

        // benchmarkHeap();

    }

    private static void benchmarkPriorityAdd(int n){
        
        long t_total = 0;
        long t0;
        int loop = 1;
        Random rnd = new Random();
 
       for (int i = 0; i < loop; i++) {

        SinglyLinkedList list = new SinglyLinkedList();

        for (int j = 0; j < n; j++)
            list.priorityAdd(rnd.nextInt(n));

            t0 = System.nanoTime();
            list.priorityAdd(rnd.nextInt(n));
            list.remove();
            t_total += System.nanoTime() - t0;
        }
        System.out.println("Priority add. n: " + n + " ns: " + t_total/loop);
    }

    private static void benchmarkPriorityRemove(int n){
        
        long t_total = 0;
        long t0;
        int loop = 1;
        Random rnd = new Random();

       for (int i = 0; i < loop; i++) {
        
        SinglyLinkedList list = new SinglyLinkedList();
        for (int j = 0; j < n; j++)
            list.priorityAdd(rnd.nextInt(n));

            t0 = System.nanoTime();
            list.priorityRemove();
            list.add(rnd.nextInt(n));
            t_total += System.nanoTime() - t0;
        }
        System.out.println("Priority remove. n: " + n + " ns: " + t_total/loop);
    }

    private static void benchmarkHeap(){

        Random rnd = new Random();

        TreeHeap tree = new TreeHeap();

        int depthPush = 0;
        int depthAdd = 0;

        for (int i = 0; i < 64; i++) {
            tree.add(rnd.nextInt(100));
        }


        for (int i = 0; i < 1000; i++) {
            depthPush += tree.push(10);
        }
        for (int i = 0; i < 1000; i++) {
            depthAdd += tree.add(rnd.nextInt(100));
        }

        depthAdd /= 1000;
        depthPush /= 1000;

        System.out.println("Avg. depth push: " + depthPush);
        System.out.println("Avg depth add: " + depthAdd);

    }
}