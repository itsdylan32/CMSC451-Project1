package sort;

/**
 * Implementation of the QuickSort algorithm with operation counting.
 */
public class QuickSort implements SortAlgorithm {

    private long operationCount = 0;

    /**
     * Sorts the input array using QuickSort.
     *
     * @param array the array to sort
     */
    @Override
    public void sort(int[] array) {
        resetOperationCount();
        if (array == null || array.length <= 1) return;
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Returns the number of critical operations (comparisons) performed during sorting.
     *
     * @return the operation count
     */
    @Override
    public long getOperationCount() {
        return operationCount;
    }

    /**
     * Resets the operation counter to 0.
     */
    @Override
    public void resetOperationCount() {
        operationCount = 0;
    }

    // Recursive QuickSort implementation
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Partition method used by QuickSort
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            operationCount++; // count comparison
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    // Swap helper
    private void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
