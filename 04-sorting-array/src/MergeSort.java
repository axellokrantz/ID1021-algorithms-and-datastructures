public class MergeSort {

    public static void sort(int[] array){

        int inputLength = array.length;

        if (inputLength < 2){
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++){
            leftHalf[i] = array[i];
        }

        for (int i = midIndex; i < inputLength; i++){
            rightHalf[i - midIndex] = array[i];
        }

        sort(leftHalf);
        sort(rightHalf);

        merge(array, leftHalf, rightHalf);
    }

    private static void merge (int[] array, int[] leftHalf, int[] rightHalf){

        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize){
            if (leftHalf[i] <= rightHalf[j]){
                array[k] = leftHalf[i];
                i++;
            }
            else{
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize){
            array[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize){
            array[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
