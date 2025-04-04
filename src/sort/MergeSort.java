package sort;

public class MergeSort implements SortAlgorithm {
    // show the operation count
    private long operationCount = 0;

    // override the sort method for the array
    @Override
    public void sort(int[] array) {
        operationCount = 0;

        // create a recursive merge sort function
        mergeSort(array, 0, array.length - 1);
    }

    // override to get the operation count
    @Override
    public long getOperationCount() {
        return operationCount;
    }

    // recursive merge sort function
    private void mergeSort(int[] array, int left, int right) {
        // check if the left index is less than the right index
        if (left < right) {
            // get the middle index
            int middle = (left + right) / 2;

            // call mergeSort recursively on the left and right halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // call the merge function
            merge(array, left, middle, right);
        }
    }

    // create a merge function
    private void merge(int[] array, int left, int mid, int right) {
        int size1 = mid - left + 1; // size of the left array
        int size2 = right - mid;    // size of the right array

        int[] L = new int[size1];
        int[] R = new int[size2];

        // copy data to temp arrays
        for (int i = 0; i < size1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < size2; j++) {
            R[j] = array[mid + 1 + j];
        }

        // merge the temp arrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < size1 && j < size2) {
            operationCount++; // critical operation: comparison
            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        // copy remaining elements of L[], if any
        while (i < size1) {
            array[k++] = L[i++];
        }

        // copy remaining elements of R[], if any
        while (j < size2) {
            array[k++] = R[j++];
        }
    }
}
