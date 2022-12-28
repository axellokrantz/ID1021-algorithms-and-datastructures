public class Calculator {
    
    Item[] expr;
    int ip; // pointer.
    StaticStack stack;

    public Calculator(Item[] expr){
        this.expr = expr;
        this.ip = 0;
        this.stack = new StaticStack();
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
            case SPECIAL : {
                int x = stack.pop();
                x = x*2;
                if (x >= 10){
                    int x2 = x/10;
                    int x3 = x%10;
                    x = x2 + x3;
                }
                    stack.push(x);
                    break;
            }
            case MOD10 : {
                int x = stack.pop();
                x = x % 10;
                stack.push(x);
                break;
            }
        }
    }       
}
