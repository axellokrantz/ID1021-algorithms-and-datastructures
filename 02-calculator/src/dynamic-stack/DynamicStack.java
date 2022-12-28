public class DynamicStack {

    int stackSize = 4;
    int sp = -1;
    public int[] dynamicStack = new int[stackSize];

    public void push (int i){
        if(sp == (stackSize-1)){
            extendStack();
        }
        sp++;
        dynamicStack[sp] = i;
    }

    public int pop(){
        if (stackSize >= 4 && sp <= (stackSize/4)){
            reduceStack();
        }
        return dynamicStack[sp--];
    }

    private void extendStack(){
        stackSize *= 2;
        int[] tempStack = new int[stackSize];
        for (int i = 0; i < stackSize/2; i++){
            tempStack[i] = dynamicStack[i];
        }
        dynamicStack = tempStack;
        System.out.println("nu blev den större hihi.");
    }

    private void reduceStack(){
        stackSize /= 2;
        int[] tempStack = new int[stackSize];
        for (int i = 0; i < stackSize; i++){
            tempStack[i] = dynamicStack[i];
        }
        dynamicStack = tempStack;
        System.out.println("nu blev den mindre hihi.");
    }

}
