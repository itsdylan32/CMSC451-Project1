import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sort.MergeSort;
import sort.QuickSort;
import sort.SortAlgorithm;
 
public class SortingGUI extends JFrame {

    private JTextField inputField;
    private JTextArea resultArea;
    private JComboBox<String> algorithmSelector;

    public SortingGUI() {
        setTitle("Sorting Visualizer");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel - Input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        inputField = new JTextField(30);
        algorithmSelector = new JComboBox<>(new String[]{"QuickSort", "MergeSort"});
        JButton sortButton = new JButton("Sort");

        inputPanel.add(new JLabel("Enter array (comma-separated):"));
        inputPanel.add(inputField);
        inputPanel.add(algorithmSelector);
        inputPanel.add(sortButton);

        // Center Panel - Output
        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Button action
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSort();
            }
        });
    }

    private void handleSort() {
        try {
            String[] tokens = inputField.getText().split(",");
            int[] array = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                array[i] = Integer.parseInt(tokens[i].trim());
            }

            SortAlgorithm sorter;
            if (algorithmSelector.getSelectedItem().equals("QuickSort")) {
                sorter = new QuickSort();
            } else {
                sorter = new MergeSort();
            }

            sorter.sort(array);

            StringBuilder output = new StringBuilder("Sorted: ");
            for (int num : array) {
                output.append(num).append(" ");
            }
            output.append("\nOperation count: ").append(sorter.getOperationCount());

            if (!Utils.isSorted(array)) {
                output.append("\n⚠️ Array is NOT sorted!");
            }

            resultArea.setText(output.toString());

        } catch (Exception ex) {
            resultArea.setText("Error: Invalid input. Please enter integers separated by commas.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SortingGUI().setVisible(true);
        });
    }
}
