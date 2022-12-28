import java.util.*;

public class BinaryTree implements Iterable<Integer> {

    Node root;

    public static class Node {

        public Integer key;
        public Integer value;

        public Node left, right;
    
        public Node (Integer key, Integer value){
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public void print() {
            if(left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null)
                right.print();
        }
    }

    public BinaryTree() {
        root = null;
    }
    
    public BinaryTree(int n){
        Random rnd = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
	    list.add(i);
        }
        Collections.shuffle(list);
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        for (int i : arr){
            add(i, rnd.nextInt(n));
        }
    }
    public void add (Integer key, Integer value){
        
        Node temp = root;

        while (temp != null){
            // If key = root key, we simply update the root value.
            if (temp.key == key){
                temp.value = value;
                return;
            }

            if (key < temp.key){
                if (temp.left == null){
                    temp.left = new Node(key, value);
                    return;
                }
                else{
                    temp = temp.left;
                }
            }

            if (key > temp.key){
                if(temp.right == null){
                    temp.right = new Node(key, value);
                    return;
                }
                else{
                    temp = temp.right;
                }
            }
        }
        root = new Node(key, value);
    }  
    public static Node lookup(Node root, Integer key){
    
    // Base Cases: root is null or key is present at root
    if (root == null || root.key == key){
        return root;
    }

    // Key is greater than root's key.
    if (root.key < key){
        return lookup(root.right, key);
    }
        // Key is smaller than root's key
        return lookup(root.left, key);
    }

    
    public Iterator<Integer> iterator() {
        return new TreeIterator(root);
    }

}
