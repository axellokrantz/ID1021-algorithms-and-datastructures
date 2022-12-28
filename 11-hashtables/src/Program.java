public class Program{
    public static void main(String[] args) {
        
        ZipHash zip = new ZipHash("postnummer.csv");
        
        zip.collisions(10_000);
        // benchmarkZip();
        
    }

    public static void benchmarkZip(){

        Zip zip = new Zip("postnummer.csv");
        ZipInteger zip2 = new ZipInteger("postnummer.csv");

        long t_total1 = 0;
        long t_total2 = 0;
        long t_total3 = 0;
        long t_total4 = 0;

        long t0;
        int loop = 10000;

        for (int i = 0; i < loop; i++){
            t0 = System.nanoTime();
            zip.linearSearch("111 15");
            zip.linearSearch("994 99”");
            t_total1 += System.nanoTime() - t0;

            t0 = System.nanoTime();
            zip.binarySearch("111 15");
            zip.binarySearch("994 99");
            t_total2 += System.nanoTime() - t0;

            t0 = System.nanoTime();
            zip2.linearSearch(11115);
            zip2.linearSearch(99499);
            t_total3 += System.nanoTime() - t0;

            t0 = System.nanoTime();
            zip2.binarySearch(11115);
            zip2.binarySearch(99499);
            t_total4 += System.nanoTime() - t0;
        }

        System.out.println("Total time for linear search: " + (double)t_total1/loop);
        System.out.println("Total time for binary search: " + (double)t_total2/loop);
        System.out.println("Total time (Integer) for linear search: " + (double)t_total3/loop);
        System.out.println("Total time (Integer) for binary search: " + (double)t_total4/loop);

    }
}