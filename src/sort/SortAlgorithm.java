package sort;

/**
 * Interface to represent a sorting algorithm.
 */
public interface SortAlgorithm {

    /**
     * Sorts the given array in-place.
     *
     * @param array the array to sort
     */
    void sort(int[] array);

    /**
     * Returns the number of critical operations (e.g., comparisons) performed during the last sort.
     *
     * @return the operation count
     */
    long getOperationCount();

    /**
     * Resets the operation count to zero. Should be called before each new sort.
     */
    void resetOperationCount();
}
