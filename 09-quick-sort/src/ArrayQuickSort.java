import java.util.Random;

public class ArrayQuickSort{
    
    // Overload the sortArray method, which means both has same name but different parameters.
    // This is done to avoid having to define lowIndex and highIndex when we call the method.
    public static void sortArray(int[] array){
        sortArray(array, 0, array.length-1);
    }

    public static void sortArray(int[] array, int lowIndex, int highIndex){
        /*
         * Three main steps.
         * #1 Choose a pivot.
         * #2 Do the partioning.
         * #3 Do the recursive quickSort calls.
         */

        if (lowIndex >= highIndex){
            return;
        }

        /*
         * In the average case, the algorithm pefroms the best if a random pivot is chosen.
         * After the pivot is chosen at random we swap the pivot with the last element.
         */
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        /*
         * Next set all numbers lower than pivot to left of pivot,
         * and all numbers greater than pivot to the right of pivot.
         * To do this we create two pointers, left and right.
         */

         /*
          * Calls quick sort recursively to sort all elements left of pivot.
          * Calls quick sort recursively to sort all elements right of pivot.
          * As the recursive calls are done over and over eventually the program will be told
          * to sort just one element. Because and array of just one element must be sorted we can implement an
          * if statement to return.
          */
        int lp = partition(array, lowIndex, highIndex, pivot);
         sortArray(array, lowIndex, lp -1);
         sortArray(array, lp + 1, highIndex);
    }

    // Method for swaping two indexes.
    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot){
        int lp = lowIndex;
        int rp = highIndex;

        // While lp and rp are not pointing to the same element:
        while(lp < rp){
           /*
            * While the value lp is pointing at is less than our pivot and rp value
            * we traverse the array.
            */
           while(array[lp] <= pivot && lp < rp){
               lp++;
           }
           /*
            * While the value rp is pointing at is greater than our pivot and lp value
            * we traverse the array.
            */
           while(array[rp] >= pivot && rp > lp){
               rp--;
           }
           /*
            * Partioning Step:
            * Left pointer traverse until it finds a value greater than our pivot number.
            * When found the pointer stops and the right pointer starts traversing down
            * the array until it finds a value less than our pivot. When the above requirements
            * are met, we swap the values through our swap() function. This process repeats until
            * the left pointer and right pointer meet at an element. This is where we swap our pivot
            * with the value that both lp and rp are pointing to.
            * 
            * Partioning Step: Done.
            * All elements less than pivot are placed to the left of pivot.
            * All elements greater than pivot are placed to the right of pivot.
            */
           swap(array, lp, rp); 
        }

        // Corner case, where last value could potentially be out of order.
        if(array[lp] > array[highIndex])
            swap(array, lp, highIndex);
        else
            lp = highIndex;

        return lp;
    }
}
