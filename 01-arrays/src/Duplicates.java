import java.util.Random;

public class Duplicates {
    public static double searchDuplicates (int n, int loop){

        int k = loop;
        int sum = 0;
        long t_total = 0;
        int[] keys = new int[n];
        int[] array = new int[n];

        Random rnd = new Random();

        for (int j = 0; j < k; j++){
            for (int a = 0; a < n; a++){
                keys[a] = rnd.nextInt(n*10);
                array[a] = rnd.nextInt(10*n);
            }

            long t0 = System.nanoTime();
            for (int ki = 0; ki < n; ki++){
                int key = keys[ki];
                for (int i = 0; i < n ; i++){
                    if (array[i] == key){
                        sum++;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
        }
        return (double)t_total/loop;
    }

    public static void main(String[] args)
    {
        System.out.println(searchDuplicates(1280, 1_000_000));
    }
}
