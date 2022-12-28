import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    
    private ListQueue que;
    BinaryTree.Node pointer;

    TreeIterator(BinaryTree.Node root)
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

        return pointer.getValue();
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException();
    }
}









/*
 * public class TreeIterator implements Iterator<Integer> {
		private Queue queue;
		Node pointer;
		
		public TreeIterator() {
			pointer = root;
			queue = new Queue();
			
			queue.add(root);
		}
		
		@Override
		public boolean hasNext(){
			return queue.start != null;
		}
		
		@Override
		public Integer next() {
			pointer = queue.remove();
			
			if(pointer.getLeft() != null)
				queue.add(pointer.getLeft());
			if(pointer.getRight() != null)
				queue.add(pointer.getRight());
			
			return pointer.getValue();
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
 */