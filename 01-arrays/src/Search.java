import java.util.Random;

// m = antalet keys.
// n = antalet sökningar.

public class Search {

    public static double searchItem (int n, int m, int loop){

        int k = loop;
        int sum = 0;
        long t_total = 0;

        Random rnd = new Random();

        int[] keys = new int[m];
        int[] array = new int[n];
        
        for (int j = 0; j < k; j++){
            for (int a = 0; a < m; a++){
                keys[a] = rnd.nextInt(n*10);
            }
            for (int b = 0; b < n; b++){
                array[b] = rnd.nextInt(n*10);
            }


            // keys[j] = rnd.nextInt(10*n);
            // array[j] = rnd.nextInt(10*n);

            long t0 = System.nanoTime();

            for (int ki = 0; ki < m; ki++){
                int key = keys[ki];
                for (int i = 0; i < n ; i++){
                    if (array[i] == key){
                        sum++;
                        break;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
        }
        return (double)t_total/loop;
    }

    public static void main(String[] args)
    {
        System.out.println(searchItem(30, 50, 1_000_000));
    }

}

