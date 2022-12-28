public class LinkedList {
    
    private int size;
    private Node head;

    private class Node{
        private int data;
        private Node next;

        public Node(int value, Node node){
            this.data = value;
            this.next = node;
        }
        public int getData(){
            return this.data;
        }
    }

    public LinkedList(){
        this.size = 0;
        this.head = null;
    }

    public int getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        return(getSize() == 0);
    }
    
    public void addNode (int value){
        Node newHead = new Node(value, this.head);
        this.head = newHead;
        this.size++;
    }
    public void removeNode(){
        if (isEmpty()) {
            System.out.println("List is empty");
        }
        this.head = head.next;
        this.size--;
    }

    public void display(){
        if (isEmpty()){
            System.out.println("The list is empty.");
        }
        else{
            System.out.println(head.getData()+ " <- Top of stack");
            Node current = head.next;
            while (current != null){
                System.out.println(current.getData());
                current = current.next;
            }
        }
    }

    public void appendBefore(LinkedList list){
        Node current = list.head;
        while(current.next != null){
            current = current.next;
        }
        current.next = this.head;
        this.head = list.head;
    }

    public void appendAfter(LinkedList list){
        Node current = this.head;
        while(current.next != null){
            current = current.next;
        }
        current.next = list.head;
    }
}
