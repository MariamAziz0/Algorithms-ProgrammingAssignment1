package Part1;
import java.util.*;

public class HelpingFunctions {

    public static void printArray(int[] array) {
        for(int i = 0 ; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int partition(int[] array, int pivot, int p, int q) {
        int j = p;
        int x = array[pivot];
        swap(array, p, pivot);
        for(int i = p + 1; i <= q ; i++) {
            if(array[i] < x) {
                j++;
                swap(array, j, i);
            }
        }
        swap(array, p, j);
        return j;
    }

    public static int getRandomNumber(int p, int q) {
        Random random = new Random();
        return random.nextInt(q - p + 1) + p;
    }
    public static int[] generateDistinctRandomArray(int size, int min, int max) {
        if (size > (max - min + 1))
            throw new IllegalArgumentException("Can't generate distinct random integers.");

        int[] result = new int[size];
        HashSet<Integer> set = new HashSet<>();

        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            int randomValue;
            do {
                randomValue = rand.nextInt(max - min + 1) + min;
            } while (set.contains(randomValue));
            set.add(randomValue);
            result[i] = randomValue;
        }
        return result;
    }

}
