import java.lang.NullPointerException;

public class ListQueue {
    
    Node front;
    Node rear;

    public class Node{
        public BinaryTree.Node node;
        public Node next;

        public Node(BinaryTree.Node node){
            this.node = node;
            this.next = null;
        }
    }

    /*
     * A class to represent a queue
     * The queue, front stores the front node of LL
     * and rear stores the last node of LL
     */ 

    public ListQueue(){
        this.front = null;
        this.rear = null;
    }
    
    // Method to add node to que
    public void enqueue(BinaryTree.Node node){

        if (front == null && rear == null){
            this.front = this.rear = new Node(node);
            return;
        }

        /*
         * Adds a node at the end, and set pointer
         * to point towards the new node.
         */

        Node temp = new Node (node);
        this.rear.next = temp;
        this.rear = temp;
    }

    BinaryTree.Node dequeue() throws NullPointerException{ 

        BinaryTree.Node node = front.node;

        if (front == null){
            throw new NullPointerException ("List is empty.");
        }

        // If there's only 1 node in list. Set both pointers to null.
        if(front == rear){
            front = rear = null;
        }
        else{
            front = front.next;
        }
        return node;
    }
}