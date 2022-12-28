package Inlämning_6;
import java.util.Random;

public class SinglyLinkedList {
    
    Node head;

    private class Node {
        int data;
        Node next;
        
        Node (int d)
        {
            data = d;
            next = null;
        }
        public int getData(){
            return this.data;
        }
    }
 
    public int deleteNodeAtIndex (int index) throws NullPointerException, IndexOutOfBoundsException
    {

        if (head == null){
            throw new NullPointerException("Invalid input.");
        }

        Node temp = head;

        if (index == 0){
            int value = head.getData();
            head = temp.next;
            return value;
        }

        for(int i = 0; temp != null && i < index - 1; i++){
            temp = temp.next;
        }

        int value = temp.next.getData();

        if (temp == null || temp.next == null)
            throw new IndexOutOfBoundsException("The specified index does not exists.");

        Node node = temp.next.next;
        temp.next = node;
        return value;
    }

    public void addNode(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public SinglyLinkedList(int length){
        this.head = new Node(1);
    
        for(int i = 1; i < length; i++){
            this.addNode(i+1);
        }
    }

    public static SinglyLinkedList generateRandomSingly(int length){

        SinglyLinkedList randomSingly = new SinglyLinkedList();
        Random rnd = new Random();

        for(int i = 0; i < length; i++){
            randomSingly.addNode(rnd.nextInt(length));
        }
        return randomSingly;
    }

    public void deleteAdd(int index){
        int deletedValue = deleteNodeAtIndex(index);
        addNode(deletedValue);
    }

    public void display(){
        Node current = head;
        System.out.println(current.getData());
        while(current.next != null){
            System.out.println(current.next.getData());
            current = current.next;
        }
    }
}
