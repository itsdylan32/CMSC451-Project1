import java.util.Random;

/**
 * Utility class for generating random arrays and checking sort correctness.
 */
public class Utils {

    /**
     * Generates a random integer array of a given size within the specified range [min, max].
     *
     * @param size the size of the array
     * @param min  the minimum possible value (inclusive)
     * @param max  the maximum possible value (inclusive)
     * @return an array of random integers
     */
    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        return array;
    }

    /**
     * Overloaded version with default range [0, 9999].
     *
     * @param size the size of the array
     * @return an array of random integers
     */
    public static int[] generateRandomArray(int size) {
        return generateRandomArray(size, 0, 9999);
    }

    /**
     * Checks if the given array is sorted in ascending order.
     *
     * @param array the array to check
     * @return true if sorted, false otherwise
     */
    public static boolean isSorted(int[] array) {
        if (array == null || array.length < 2) return true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
