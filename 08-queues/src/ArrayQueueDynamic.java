import java.util.Arrays;

public class ArrayQueueDynamic {
    
        private Integer[] array;
        private int i, k;
    
        ArrayQueueDynamic(int size){
            this.array = new Integer[size];
            this.i = 0;
            this.k = 0;
        }
    
        Integer remove(){
            if (array[i] == null){
                throw new IndexOutOfBoundsException("Array is empty.");
            }
    
            Integer value = array[i];
            array[i++] = null;
    
            //wrap around
            if(i == array.length){
                i = 0;
            }
            return value;
        }
    
        void add (Integer value){
            if(k == array.length)
                k = 0;

            if(array[k] != null){
                expand();
            }
            array[k++] = value;
        }

        private void expand(){
            Integer[] expandedArray = new Integer [2*array.length];

            int j = i;
            int n = 1;

            expandedArray[0] = array[j++];

            while(j != i){

                if(j == array.length) 
                j = 0;
                else{
                expandedArray[n++] = array[j++];
            }
            
            }
            k = array.length;
            i = 0;
            array = expandedArray;
        }
        public void printArray(){
            System.out.println(Arrays.toString(array));
        }
    }