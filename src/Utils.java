import java.util.Random;

// Utility class for generating random arrays and checking sort correctness
public class Utils {

    // Generate a random int array of given size and range [min, max]
    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        return array;
    }

    // Overloaded version with default min=0 and max=9999
    public static int[] generateRandomArray(int size) {
        return generateRandomArray(size, 0, 9999);
    }

    // Check if an array is sorted in ascending order
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
