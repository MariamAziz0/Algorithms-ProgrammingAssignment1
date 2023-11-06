package Part1;

public class RandomizedDivideANDConquer {

    private static Integer randomizedSelection(Integer[] a, int p, int q, int i) {
        if(p == q)
            return a[p];
        int pivot = HelpingFunctions.getRandomNumber(p, q);
        int r = HelpingFunctions.partition(a, pivot, p, q);
        int k = r - p + 1;
        if(i == k)
            return a[r];
        if(i < k)
            return randomizedSelection(a, p, r - 1 , i);
        else
            return randomizedSelection(a, r + 1, q, i - k);
    }

    public static Integer randomizedSelection(Integer[] a, int i) {
        return randomizedSelection(a, 0, a.length - 1, i);
    }
}
