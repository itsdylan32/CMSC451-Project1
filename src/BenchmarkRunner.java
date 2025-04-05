import java.util.*;
import sort.*;
import gui.BenchmarkReportGUI;


public class BenchmarkRunner {
    public static final int TRIALS = 40;

    public static Map<Integer, double[]> runBenchmark(SortAlgorithm sorter, int[] sizes) {
        Map<Integer, double[]> countsMap = new TreeMap<>();
        Map<Integer, double[]> timesMap = new TreeMap<>();

        for (int size : sizes) {
            double[] counts = new double[TRIALS];
            double[] times = new double[TRIALS];

            for (int t = 0; t < TRIALS; t++) {
                int[] array = Utils.generateRandomArray(size);
                int[] arrayCopy = array.clone();

                long startTime = System.nanoTime();
                sorter.sort(arrayCopy);
                long endTime = System.nanoTime();

                counts[t] = sorter.getOperationCount();
                times[t] = (endTime - startTime) / 1_000_000.0; // Convert to ms
            }

            countsMap.put(size, counts);
            timesMap.put(size, times);
        }

        BenchmarkReportGUI.showBenchmarkReport(countsMap, timesMap);
        return countsMap;
    }
}
