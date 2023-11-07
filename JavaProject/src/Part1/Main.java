package Part1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] array = new int[] {6, 10, 13, 5, 8, 3, 2, 11, 12, 15, 200, 1, 1};
//        for(int i = 0 ; i < array.length ; i++){
//            System.out.println(RandomizedDivideANDConquer.randomizedSelection(array, i + 1) + " " +
//                    DeterministicLinearTimeSelection.linearTimeSelection(array, i + 1) + " " +
//                    SortingSelection.sortingSelection(array, i + 1));
//        }

        System.out.println("-----------------------------------------------------------------------------");

        int[] array2 = HelpingFunctions.generateDistinctRandomArray(100000, -100000, 100000);
//        for(int i = 0 ; i < array2.length ; i++){
//            System.out.println(RandomizedDivideANDConquer.randomizedSelection(array2, i + 1) + " " +
//                    DeterministicLinearTimeSelection.linearTimeSelection(array2, i + 1) + " " +
//                    SortingSelection.sortingSelection(array2, i + 1));
//        }
        long startTime = System.nanoTime() / 1000;
//        for(int i = 0 ; i < array2.length ; i++) {
//            RandomizedDivideANDConquer.randomizedSelection(array2, i+1);
//        }
        RandomizedDivideANDConquer.randomizedSelection(Arrays.copyOf(array2, array2.length), array2.length / 2);
        long endTime = System.nanoTime() / 1000;
        System.out.println("Time taken by random: " + ((endTime - startTime)));

        startTime = System.nanoTime() / 1000;
//        for(int i = 0 ; i < array2.length ; i++) {
//            DeterministicLinearTimeSelection.linearTimeSelection(array2, i+1);
//        }
        DeterministicLinearTimeSelection.linearTimeSelection(Arrays.copyOf(array2, array2.length), array2.length / 2);
        endTime = System.nanoTime() / 1000;
        System.out.println("Time taken by linear: " + ((endTime - startTime)));

        startTime = System.nanoTime() / 1000;
//        for(int i = 0 ; i < array2.length ; i++) {
//            SortingSelection.sortingSelection(array2, i+1);
//        }
        SortingSelection.sortingSelection(Arrays.copyOf(array2, array2.length), array2.length / 2);
        endTime = System.nanoTime() / 1000;
        System.out.println("Time taken by sorting: " + ((endTime - startTime)));
    }
}
