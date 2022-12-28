public class SinglyQuickSort {

    public static class Node{
    int value;
    Node next;
        
    Node(int value){
    this.value = value;
    this.next = null;
        }
    }
        
    Node head;
        
    void addNode(int value){
    Node temp = new Node(value);
    temp.next = head;
    head = temp;
    }
    
    public Node getTail(){
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        return current;
    }

    void display(){
    Node current = this.head;
        while(current != null){
        System.out.print(current.value + " ");
        current = current.next;
        }
    }
    
    private static SinglyQuickSort.Node partition(SinglyQuickSort.Node first, SinglyQuickSort.Node last){
        if(first == last || first == null || last == null )
            return first;

            SinglyQuickSort.Node beforePivot = first;
            SinglyQuickSort.Node current = first;
            int pivot = last.value;  

        while(first != last){
            if(first.value < pivot){ 
                beforePivot = current;
                int temp = current.value;
                current.value = first.value;
                first.value = temp; 
                current = current.next;
            } 
            first = first.next;
        }

        int temp = current.value;
        current.value = pivot;
        last.value = temp;

        return beforePivot;
    }

    public static void sort(SinglyQuickSort.Node first, SinglyQuickSort.Node last){
        if(first == null || first == last || first == last.next)
            return;

        SinglyQuickSort.Node beforePivot = partition(first, last);
        sort(first, beforePivot);

        if(beforePivot != null && beforePivot == first)
            sort(beforePivot.next, last);

        else if(beforePivot != null && beforePivot.next != null)
            sort(beforePivot.next.next, last);    
    }
}
