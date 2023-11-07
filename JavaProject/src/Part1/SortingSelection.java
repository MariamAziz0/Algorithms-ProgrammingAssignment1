package Part1;

import java.util.Arrays;

public class SortingSelection {
    public static Integer sortingSelection(int[] a, int i) {
        Arrays.sort(a);
        return a[i - 1];
    }
}
