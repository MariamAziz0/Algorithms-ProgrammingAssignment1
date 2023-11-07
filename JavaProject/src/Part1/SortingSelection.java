package Part1;

import java.util.Arrays;

public class SortingSelection {
    public static int sortingSelection(int[] a, int i) {
        Arrays.sort(a);
        return a[i - 1];
    }

}
