public class Calculator {
    
    Item[] expr;
    int ip; // pointer.
    DynamicStack stack;

    public Calculator(Item[] expr){
        this.expr = expr;
        this.ip = 0;
        this.stack = new DynamicStack();
    }
    
    public int run(){
        while (ip < expr.length){
            step();
        }
        return stack.pop();
    }
    
    public void step(){
        Item nxt = expr[ip++];

        switch(nxt.type()){
            case ADD : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x+y);
                break;
            }
            case SUB : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x-y);
                break;
            }
            case MUL : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x*y);
                break;
            }
            case DIV : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x/y);
                break;
            }
            case VALUE : {
                stack.push(nxt.getValue());
                break;
            }
        }
    }
}
