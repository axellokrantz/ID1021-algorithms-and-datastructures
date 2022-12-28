import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeIterator implements Iterator<Integer> {
    
    private Stack stack;

    TreeIterator(BinaryTree.Node root)
    {
        stack = new Stack();
        moveLeft(root);
    }

    private void moveLeft(BinaryTree.Node current)
    {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }
    @Override
    public boolean hasNext()
    {
        return !stack.isEmpty();
    }
    public Integer next()
    {
        if (!hasNext())
            throw new NoSuchElementException();
 
        BinaryTree.Node current = stack.pop();
 
        if (current.right != null)
            moveLeft(current.right);
 
        return current.value;
    }
}
