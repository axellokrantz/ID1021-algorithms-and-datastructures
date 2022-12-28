import java.util.Iterator;

public class TreeHeap implements Iterable<Integer> {
    
    Node root;

    class Node {

        private Node left;
        private Node right;
        private int size;
        private Integer priority;

        private Node(Integer priority) {
            this.size = 1;
            this.priority = priority;
            this.left = null;
            this.right = null;
          }

        public Node getRight(){
            return this.right;
        }

        public Node getLeft(){
            return this.left;
        }


        public Integer getPriority(){
            return this.priority;
        }

        private Integer add(Integer prio) {
            if(prio < this.priority) {
              Integer tmp = this.priority;
              this.priority = prio;
              prio = tmp;
            }
            size++;
      
            if(this.left == null) {
              this.left = new Node(prio);
              return 1;
            } else if(this.right == null) {
              this.right = new Node(prio);
              return 1;
            } else if(this.right.size < this.left.size) {
              return this.right.add(prio) + 1;
            } else {
              return this.left.add(prio) + 1;
            }
          }

        public Node remove(){
            if(this.left == null){
                this.priority = this.right.priority;
                this.right = null;
                this.size--;
                return this;
            }
            if(this.right == null){
                this.priority = this.left.priority;
                this.left = null;
                this.size--;
                return this;
            }
            // if right priority is lower than left, we promote the right node. 
            if (this.right.priority < this.left.priority){
                
                this.priority = this.right.priority;
                this.size--;

                if(this.right.size == 1)
                    this.right = null;
                else
                    this.right = this.right.remove();
                return this;
            }
            // else left priority is lower than right priority and we promote left.
            else{
                this.priority = this.left.priority;
                this.size--;

                if(this.left.size == 1)
                    this.left = null;
                else
                    this.left = this.left.remove();
            }
            return this;
        }
    }

    public TreeHeap(){
        root = null;
    }

    public Integer add(Integer priority) {
        if(root != null) {
          return root.add(priority);
        }
    
        root = new Node(priority);
        return 0;
      }

    public void remove() throws NullPointerException{
        
        if (root == null){
            throw new NullPointerException("Heap is empty.");
        }
        else if(root.right == null && root.left == null){
            root = null;
        }
        else{
            root.remove();
        }
    }

    public void swap(Node up, Node down){
        Integer tempPriority = down.priority;
        down.priority = up.priority;
        up.priority = tempPriority;
    }

    // Overrider push method with different param.
    public int push(int increment){
        this.root.priority += increment;
        Node temp = this.root;
        return push(this.root.priority, temp, 0);
    }

    private int push (Integer newPriority, Node temp, int depth){
        if (temp.left == null){
            // If the new priority is less than right priority
            // we dont need to move the node further down the tree.
            // We are done and return the current depth.
            if (newPriority < temp.right.priority){
                return depth;
            }
            // If the new priority is higher than right priority.
            // We swap the two nodes and increase depth.
            else {
                depth++;
                swap(temp.right, temp);
            }

            // If temp.right have children nodes we call the push method recursively.
            if (temp.right.size != 1){
                depth = push(newPriority, temp.right, depth);
            }
        }

        if (temp.right == null){
            if(newPriority < temp.left.priority){
                return depth;
            }
            else{
                depth++;
                swap(temp.left, temp);
            }

            if (temp.left.size != 1){
                depth = push(newPriority, temp.left, depth);
            }
        }

        // If none of the children nodes are null, we check which direction to go.

        if (temp.right != null && temp.left.priority > temp.right.priority){
            if (temp.right.priority > newPriority){
                return depth;
            }
            else {
                depth++;
                swap(temp.right, temp);
            }
            if (temp.right.size != 1)
                depth = push(newPriority, temp.right, depth);
        }
        else {
            if(temp.left.priority > newPriority){
                return depth;
            }
            else{
                depth++;
                swap(temp.left, temp);
            }
            if (temp.left.size != 1){
                depth = push(newPriority, temp.left, depth);
            }
        }
        return depth;
    }

    public Iterator <Integer> iterator() {
        return new TreeIterator(root);
    }

}
