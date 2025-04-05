package sort;

/**
 * Implementation of the MergeSort algorithm with operation counting.
 */
public class MergeSort implements SortAlgorithm {

    private long operationCount = 0;

    /**
     * Sorts the given array using MergeSort.
     *
     * @param array the array to sort
     */
    @Override
    public void sort(int[] array) {
        resetOperationCount();
        if (array == null || array.length <= 1) return;
        mergeSort(array, 0, array.length - 1);
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

    // Recursive MergeSort implementation
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    // Merge two sorted subarrays into the original array
    private void merge(int[] array, int left, int mid, int right) {
        int size1 = mid - left + 1;
        int size2 = right - mid;

        int[] L = new int[size1];
        int[] R = new int[size2];

        for (int i = 0; i < size1; i++) {
            L[i] = array[left + i];
        }

        for (int j = 0; j < size2; j++) {
            R[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < size1 && j < size2) {
            operationCount++; // count comparison
            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        while (i < size1) {
            array[k++] = L[i++];
        }

        while (j < size2) {
            array[k++] = R[j++];
        }
    }
}
