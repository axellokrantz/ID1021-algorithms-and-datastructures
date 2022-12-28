public class SinglyLinkedList {
    
    public class Node {
        Node next;
        int value;

        Node(int value){
            this.value = value;
            this.next = null;
        }
    }
        
    Node head;

    public void add(int value){
            Node temp = new Node(value);

            if (head == null)
                head = temp;
            else
                temp.next = head;
                head = temp;
        }

    public Node priorityRemove(){
           Node smallest = head;
           Node temp = head;
           Node previous = null;

           /*
            * Traverse the list. Find the smallest value, assign smallest to it.
            */
            while(temp != null){
            if (temp.next != null && temp.next.value < smallest.value){
                smallest = temp.next;
                previous = temp;
            }
            temp = temp.next;
            }

            /*
            * If smallest element is not head, we remove smallest.
            * If smallest element is head, we remove head.
            */
           if(smallest != head)
           previous.next = smallest.next;
           else
           head = head.next;

           return smallest;
    }

    public Node remove(){
        
        if (head == null){
            return null;
        }
        Node temp = head;
        head = head.next;
        return temp;
    }

    public void priorityAdd(int value){

        Node temp = new Node (value);

        if (head == null || head.value >= value){
            temp.next = head;
            head = temp;
        }
        else{
            Node current = head;
            while(current.next != null && current.next.value < value){
                current = current.next;
            }
            temp.next = current.next;
            current.next = temp;
        }






    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

}
