package Inlämning_6;

import java.util.Random;

public class Program {
    public static void main(String[] args) {
        
      /*   DoublyLinkedList a = new DoublyLinkedList(10);
        DoublyLinkedList.Node arrayNode[] = new DoublyLinkedList.Node [10];
        int i = 0;

        DoublyLinkedList.Node current = a.getHead();

        while(current.next != null){
            arrayNode[i++] = current;
            current = current.next;
        }
        arrayNode[i] = current;

        a.deleteAdd(arrayNode[1]);
        a.display(); */

        benchmark(20000, 10);
    }

    public static void benchmark (int n, int operations){

        Random rnd = new Random();
        long t_total_singly = 0;
        long t_total_doubly = 0;
        int loop = 100_000;

        for(int q = 0; q < loop; q++){
        SinglyLinkedList singly = new SinglyLinkedList(n);
        DoublyLinkedList doubly = new DoublyLinkedList(n);

        DoublyLinkedList.Node doublyArray[] = new DoublyLinkedList.Node[n];
        
        DoublyLinkedList.Node current = doubly.getHead();
        int i = 0;
        
        while(current.next != null){
            doublyArray[i++] = current;
            current = current.next;
        }
        doublyArray[i] = current;
        
        int[] sequence = new int[operations];

            for (int j = 0; j < operations; j++){
                sequence[j] = rnd.nextInt(1,n);
            }
            
            long t0 = System.nanoTime();
            
            t0 = System.nanoTime();

            for(int m = 0; m < operations; m++){
                doubly.deleteNode(doublyArray[sequence[m]]);
                doubly.addNodeHead(doublyArray[sequence[m]]);
            }
            t_total_doubly += (System.nanoTime() - t0);
        }
        // System.out.println("Singly total time: " + (double)t_total_singly/loop + "ns.");
        System.out.println("Doubly total time: " + (double)t_total_doubly/loop + "ns.");
    }
}
