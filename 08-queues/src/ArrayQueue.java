public class ArrayQueue {
    
    private Integer[] array;
    private int size;
    private int i, k;

    ArrayQueue(int size){
        this.size = size;
        this.array = new Integer[size];
        this.i = 0;
        this.k = 0;
    }
    Integer remove(){
        if (i == k){
            throw new IndexOutOfBoundsException("Array is empty.");
        }
        Integer value = array[i];
        array[i] = null;

        // Wrap around.
        if (i == size - 1)
            i = 0;
        else
            i++;
        return value;
    }
    void add (Integer value){

        if(k == array.length)
            k = 0;
    
        if(i == k && array[i] != null){
            throw new ArrayIndexOutOfBoundsException("Array is full.");
        }
        array[k++] = value;
    }
    public void display()
    {
        int p = i;
        while(array[p] != null){
            System.out.print(array[p++] + " ");
            if(p == i)
                return;
            if(p == array.length)
                p = 0;
        }
        return;
    }
}
