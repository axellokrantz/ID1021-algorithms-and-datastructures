public class InsertionSort {

    public static void sort(int[] array){

        int temp;
        int holePos;

        for (int i = 1; i < array.length; i++){
            holePos = i;
            temp = array[i];
            
            while(holePos > 0 && temp < array[holePos -1]){
                array[holePos] = array[holePos -1];
                holePos--;
            }
            array[holePos] = temp;
        }
    }
}
