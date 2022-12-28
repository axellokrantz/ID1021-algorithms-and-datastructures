public class Stack {
    
    private BinaryTree.Node[] stack;
    private int sp;

    Stack(){
        this.sp = 0;
        stack = new BinaryTree.Node[1];
    }

    public int size() {
        return (this.stack.length);
    }

    private void resize(int amount) {
        BinaryTree.Node[] newStack = new BinaryTree.Node[amount];
        for (int i = 0; i < this.sp; i++) {
            newStack[i] = this.stack[i];
        }
        this.stack = newStack;
    }
    
    public void push(BinaryTree.Node item){
        if(this.sp == size()){
            resize(2*size());
        }
        this.stack[this.sp++] = item;
    }

    public BinaryTree.Node pop(){
        BinaryTree.Node poppedNode = this.stack[--this.sp];
        this.stack[this.sp] = null;  
        if (this.sp > 0 && this.sp == size()/4)
            resize(size()/2);
        return poppedNode;
    }

    public void print(){
        for (int i = 0; i < stack.length && stack[i] != null; i++) {
            System.out.println(stack[i].value);
        }
    }

    public boolean isEmpty(){
        if (stack[0] == null)
        {
            return true;
        }
        else
            return false;
    }
}
