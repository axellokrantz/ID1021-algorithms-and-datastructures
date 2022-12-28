import java.util.Random;

public class RandomAccess
{
    private static double access (int n, int loop)
    {
        int k = loop;
        int sum = 0;
        Random rnd = new Random();
        int[] indx = new int [n];

        for (int i = 0; i < n; i++){
            indx[i] = rnd.nextInt(n);
        }
        int[] array = new int [n];
        for (int i = 0; i < n; i++){
            array[i] = 1;
        }

        long t0 = System.nanoTime();

        for (int j = 0; j < k; j++){

            for (int i = 0; i < n; i++)
            {
                sum += array[indx[i]];
            }
        }

        // access the array with the index given by indx[i]
        // sum up the result

        long t_access = (System.nanoTime() - t0);

        return ((double)(t_access))/((double)k*(double)n);

        /*
        t0 = System.nanoTime();
        
        // do the same loop iteration but only do a dummy add operation


        for (int j = 0; j < k; j++){

            for (int i = 0; i < l; i++)
            {
                sum += array[i];
            }
        }
        long t_dummy = (System.nanoTime() - t0);
        return ((double)(t_access - t_dummy))/((double)k*(double)l);
        */
        
    }
    public static void main(String[] args)
    {
        System.out.println(access(10000, 1_000_000));
    }
}
