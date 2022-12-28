package Inlämning_6;

public class DoublyLinkedList {
    
    Node head;

    static class Node {
        int data;
        Node next, prev;

        public int getData(){
            return this.data;
        }

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList(int length){

        this.head = new Node(1);
        for (int i = 1; i < length; i++){
            this.addNode(i+1);
        }
    }

    public void addNode(int newData){
        Node newNode = new Node(newData);
        newNode.prev = null;
        newNode.next = head;

        if (head != null){
            head.prev = newNode;
        }
        head = newNode;
    }

    public void deleteNode(Node del) throws NullPointerException { 
        
        if (head == null || del == null) {
            return;
        }
 
        if (head == del) {
            head = del.next;
        }
 
        // Change next only if node to be deleted
        // is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }
 
        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }
 
        // Finally, free the memory occupied by del
        return;
    }

    public void addNodeHead(Node ref){
        ref.next = head;
        ref.prev = null;
        head = ref;
    }

    public void display(){
        Node current = head;
        System.out.println(current.getData());
        while(current.next != null){
            System.out.println(current.next.getData());
            current = current.next;
        }
    }

    public Node getHead(){
        return head;
    }
}
