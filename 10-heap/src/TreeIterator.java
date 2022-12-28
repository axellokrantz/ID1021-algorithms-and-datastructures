import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    
    private ListQueue que;
    TreeHeap.Node pointer;

    TreeIterator(TreeHeap.Node root)
    {
        pointer = root;
        que = new ListQueue();
        que.enqueue(root);
    }

    @Override
    public boolean hasNext()
    {
        return que.front != null;
    }

    @Override
    public Integer next()
    {
        pointer = que.dequeue();

        if (pointer.getLeft() != null){
            que.enqueue(pointer.getLeft());
        }
        if (pointer.getRight() != null){
            que.enqueue(pointer.getRight());
        }

        return pointer.getPriority();
    }
    @Override
    public void remove(){
        throw new UnsupportedOperationException();
    }
}
