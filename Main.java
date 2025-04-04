import sort.MergeSort;
import sort.QuickSort;
import sort.SortAlgorithm;

public class Main {
    public static void main(String[] args) {
        // Generate one random array and clone it for both sorts
        int[] originalArray = Utils.generateRandomArray(10); // size 10
        int[] arrayForQuickSort = originalArray.clone();
        int[] arrayForMergeSort = originalArray.clone();

        // --- QuickSort Test ---
        SortAlgorithm quickSort = new QuickSort();
        quickSort.sort(arrayForQuickSort);

        System.out.print("QuickSort Result: ");
        printArray(arrayForQuickSort);
        System.out.println("QuickSort Operation Count: " + quickSort.getOperationCount());

        if (Utils.isSorted(arrayForQuickSort)) {
            System.out.println("QuickSort: Array is correctly sorted.\n");
        } else {
            System.out.println("QuickSort: ERROR - array is NOT sorted.\n");
        }

        // --- MergeSort Test ---
        SortAlgorithm mergeSort = new MergeSort();
        mergeSort.sort(arrayForMergeSort);

        System.out.print("MergeSort Result: ");
        printArray(arrayForMergeSort);
        System.out.println("MergeSort Operation Count: " + mergeSort.getOperationCount());

        if (Utils.isSorted(arrayForMergeSort)) {
            System.out.println("MergeSort: Array is correctly sorted.");
        } else {
            System.out.println("MergeSort: ERROR - array is NOT sorted.");
        }
    }

    // Helper method to print an array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
