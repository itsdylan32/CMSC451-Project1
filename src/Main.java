import sort.MergeSort;
import sort.QuickSort;
import sort.SortAlgorithm;
import gui.BenchmarkReportGUI;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Define the sizes to test
        int[] sizes = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200};

        // Choose the algorithm to benchmark
        SortAlgorithm algorithm = new QuickSort(); // Change to new MergeSort() if needed

        // Store results in maps
        Map<Integer, double[]> countMap = new TreeMap<>();
        Map<Integer, double[]> timeMap = new TreeMap<>();

        final int TRIALS = 40;

        for (int size : sizes) {
            double[] opCounts = new double[TRIALS];
            double[] times = new double[TRIALS];

            for (int t = 0; t < TRIALS; t++) {
                int[] array = Utils.generateRandomArray(size);
                int[] arrayCopy = array.clone();

                algorithm.resetOperationCount(); // Make sure to reset before sorting

                long startTime = System.nanoTime();
                algorithm.sort(arrayCopy);
                long endTime = System.nanoTime();

                opCounts[t] = algorithm.getOperationCount();
                times[t] = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
            }

            countMap.put(size, opCounts);
            timeMap.put(size, times);
        }

        // Show results in the GUI
        BenchmarkReportGUI.showBenchmarkReport(countMap, timeMap);
    }
}
