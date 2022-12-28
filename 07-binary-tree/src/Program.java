import java.util.*;

public class Program {
    public static void main(String[] args) {
        
        BinaryTree tree = new BinaryTree();
        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);

       /*  for (int i : tree){
            System.out.println("next value " + i);
        } */

        Iterator<Integer> iterator = tree.iterator();
        System.out.println(" next: " + iterator.next());
        tree.root.print();
        System.out.println(" next: " + iterator.next());
        System.out.println(" next: " + iterator.next());
        System.out.println(" next: " + iterator.next());
        System.out.println(" next: " + iterator.next());
        tree.add(4,999);
        System.out.println(" next: " + iterator.next());
        System.out.println(" next: " + iterator.next());
        
        

    }

    public static void benchmark(){
        
        int loop = 10_000;
        Random rnd = new Random();

        for (int k = 100; k <= 12800; k *=2){
            long t_total = 0;
            for(int i = 0; i < loop; i++){
                BinaryTree binary = new BinaryTree(k);
                long t0 = System.nanoTime();
                BinaryTree.lookup(binary.root, rnd.nextInt(k));
                t_total += System.nanoTime() - t0;
            }
            System.out.printf("n: %-6d %.2fns%n", k, (double)t_total/(double)loop);
        }
    }
}
