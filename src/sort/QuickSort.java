package sort;

// create a public class to represent a sorting algorithm
public class QuickSort implements SortAlgorithm {

    // introduce operation counter
    private long operationCount = 0;

    // override the sort method
    @Override
    public void sort(int[] array) {
        operationCount = 0;

        // check if the array is null or empty
        if (array == null || array.length <= 1) return;

        // call the recursive quicksort helper
        quickSort(array, 0, array.length - 1);
    }

    // override to get the operation count
    @Override
    public long getOperationCount() {
        return operationCount;
    }

    // recursive quicksort implementation
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // partition the array and get pivot index
            int pi = partition(array, low, high);

            // recursively sort elements before and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // partition method
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];  // choose last element as pivot
        int i = low - 1;  // index of smaller element

        for (int j = low; j < high; j++) {
            operationCount++; // count comparison
            if (array[j] <= pivot) {
                i++;

                // swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap array[i+1] and array[high] (pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
