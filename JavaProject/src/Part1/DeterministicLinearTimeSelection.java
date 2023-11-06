package Part1;
import java.util.*;

public class DeterministicLinearTimeSelection {
    public static Integer linearTimeSelection(Integer[] array, int i) {
        return linearTimeSelection(array, 0, array.length - 1, i);
    }

    private static Integer linearTimeSelection(Integer[] array, int p, int q, int i) {
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


    private static int getMedianOf5Elements(Integer[] array){
        Arrays.sort(array);
        return array[array.length / 2];
    }

    private static int getPivot(Integer[] array, int p, int q) {
        if(p == q)
            return array[p];
        ArrayList<Integer> medians = new ArrayList<>();
        for(int i = p ; i <= q ; i+=5){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0 ; j < 5 && i+j <= q ; j++) {
                temp.add(array[i + j]);
            }
            Integer[] medians5 = new Integer[temp.size()];
            for(int j = 0 ; j < temp.size() ; j++) {
                medians5[j] = temp.get(j);
            }
            medians.add(getMedianOf5Elements(medians5));
        }
        int x = 0;
        Integer[] mediansArray = new Integer[medians.size()];
        for(int j = 0 ; j < medians.size() ; j++) {
            mediansArray[j] = medians.get(j);
        }
//        System.out.println("Median array:");
//        printArray(mediansArray);
        if(medians.size() > 5)
            x = getPivot(mediansArray, 0, medians.size() - 1);
        else
            x = getMedianOf5Elements(mediansArray);
//        System.out.println("X: " + x);
        return x;
    }

    private static Integer findInArray(Integer[] array, int x) {
        for(int i = 0 ; i < array.length ; i++) {
            if(array[i] == x)
                return i;
        }
        return 0;
    }
}
