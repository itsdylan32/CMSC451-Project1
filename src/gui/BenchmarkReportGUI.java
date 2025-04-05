
package gui;

import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * GUI class for displaying benchmark results in a table.
 */
public class BenchmarkReportGUI {

    // Calculate average of a data array
    private static double getAverage(double[] data) {
        return Arrays.stream(data).average().orElse(0.0);
    }

    // Calculate coefficient of variance (std dev / mean * 100)
    private static double getCoefficientOfVariance(double[] data) {
        double avg = getAverage(data);
        double variance = Arrays.stream(data)
                .map(d -> Math.pow(d - avg, 2))
                .average().orElse(0.0);
        double stdDev = Math.sqrt(variance);
        return (avg != 0) ? (stdDev / avg) * 100 : 0;
    }

    /**
     * Builds and displays a GUI benchmark report using JTable.
     *
     * @param countDataMap map of data size to operation counts
     * @param timeDataMap  map of data size to execution times
     */
    public static void showBenchmarkReport(Map<Integer, double[]> countDataMap,
                                           Map<Integer, double[]> timeDataMap) {
        String[] columnNames = {"Size", "Avg Count", "Coef Count", "Avg Time", "Coef Time"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        countDataMap.keySet().stream().sorted().forEach(size -> {
            double[] countData = countDataMap.get(size);
            double[] timeData = timeDataMap.get(size);

            double avgCount = getAverage(countData);
            double coefCount = getCoefficientOfVariance(countData);
            double avgTime = getAverage(timeData);
            double coefTime = getCoefficientOfVariance(timeData);

            model.addRow(new Object[]{
                    size,
                    String.format("%.2f", avgCount),
                    String.format("%.2f%%", coefCount),
                    String.format("%.2f", avgTime),
                    String.format("%.2f%%", coefTime)
            });
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Benchmark Report");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 400);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}
