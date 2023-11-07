package Part1;
import java.util.*;

public class DeterministicLinearTimeSelection {
    public static int linearTimeSelection(int[] array, int i) {
        return linearTimeSelection(array, 0, array.length - 1, i);
    }

    private static int linearTimeSelection(int[] array, int p, int q, int i) {
        int pivot = getPivot(array, p, q);
        int pivot_index = findInArray(array, pivot);
        int index = HelpingFunctions.partition(array, pivot_index, p, q);
        int k = index - p + 1;
        if(i == k)
            return pivot;
        else if(i < k)
            return linearTimeSelection(array, p, index - 1, i);
        else
            return linearTimeSelection(array, index + 1, q, i - k);
    }


    private static int getMedianOf5Elements(int[] array){
        Arrays.sort(array);
        return array[array.length / 2];
    }

    private static int getPivot(int[] array, int p, int q) {
        if(p == q)
            return array[p];
        int[] mediansArray = new int[(int) Math.ceil((q - p + 1) / 5.0)];
        int last_element = p;
        for(int i = 0 ; i < (q - p + 1) / 5 ; i++) {
            int[] temp = new int[5];
            for(int j = 0 ; j < 5 ; j++) {
                temp[j] = array[last_element];
                last_element++;
            }
            mediansArray[i] = getMedianOf5Elements(temp);
        }
        if((q - p + 1) % 5 > 0) {
            int[] temp = new int[(q - p + 1) % 5];
            for(int i = last_element; i <= q ; i++) {
                temp[i-last_element] = array[i];
            }
            mediansArray[mediansArray.length - 1] = getMedianOf5Elements(temp);
        }
        int x = 0;
        if(mediansArray.length > 5)
            x = getPivot(mediansArray, 0, mediansArray.length - 1);
        else
            x = getMedianOf5Elements(mediansArray);
        return x;
    }

    private static int findInArray(int[] array, int x) {
        for(int i = 0 ; i < array.length ; i++) {
            if(array[i] == x)
                return i;
        }
        return 0;
    }
}
