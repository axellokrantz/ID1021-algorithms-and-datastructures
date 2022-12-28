public class Program {
    public static void main(String[] args) {
        
    ArrayQueueDynamic q = new ArrayQueueDynamic(5);
    //ArrayQueue q = new ArrayQueue(4);

    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);

    q.printArray();

    q.remove();
    q.remove();
    q.remove();

    q.printArray();
    q.remove();
    q.printArray();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.printArray();

    q.add(6);
    q.printArray();
    //q.display();
    
    /*BinaryTree tree = new BinaryTree();
    tree.add(5,105);
    tree.add(2,102);
    tree.add(7,107);
    tree.add(1,101);
    tree.add(8,108);
    tree.add(6,106);
    tree.add(3,103);
    for (int i : tree)
    System.out.println("next value " + i);
    */

    }
}
