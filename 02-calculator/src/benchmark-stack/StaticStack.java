public class StaticStack {

    public int[] staticStack = new int[16];
    int sp = -1;

    public void resetStackPointer(){
        this.sp = -1;
    }

    public void push (int i){
        if(sp == 16){
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
