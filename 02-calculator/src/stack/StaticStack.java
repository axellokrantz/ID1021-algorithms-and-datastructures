public class StaticStack {

    public int[] staticStack = new int[4];
    int sp = -1;

    public void push (int i){
        if(sp == 4){
            System.out.println("Stack is full.");
        }
        else{
            staticStack[++sp] = i;
        }
    }
    public int pop(){
        if (sp == -1){
            return Integer.MIN_VALUE;
        }
        return staticStack[sp--];
    }
}
