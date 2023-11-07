package Part1;

import java.util.Arrays;

public class Main {
//    public static void main(String[] args) {
////        int[] array = new int[] {6, 10, 13, 5, 8, 3, 2, 11, 12, 15, 200, 1, 1};
////        for(int i = 0 ; i < array.length ; i++){
////            System.out.println(RandomizedDivideANDConquer.randomizedSelection(array, i + 1) + " " +
////                    DeterministicLinearTimeSelection.linearTimeSelection(array, i + 1) + " " +
////                    SortingSelection.sortingSelection(array, i + 1));
////        }
//
//        System.out.println("-----------------------------------------------------------------------------");
//
//        int[] array2 = HelpingFunctions.generateDistinctRandomArray(10000000, -10000000, 10000000);
////        for(int i = 0 ; i < array2.length ; i++){
////            System.out.println(RandomizedDivideANDConquer.randomizedSelection(array2, i + 1) + " " +
////                    DeterministicLinearTimeSelection.linearTimeSelection(array2, i + 1) + " " +
////                    SortingSelection.sortingSelection(array2, i + 1));
////        }
//        long startTime = System.currentTimeMillis();
////        for(int i = 0 ; i < array2.length ; i++) {
////            RandomizedDivideANDConquer.randomizedSelection(array2, i+1);
////        }
//        int random = RandomizedDivideANDConquer.randomizedSelection(Arrays.copyOf(array2, array2.length), array2.length / 2);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Time taken by random (" + random + "): " + ((endTime - startTime)));
//
//        startTime = System.currentTimeMillis();
////        for(int i = 0 ; i < array2.length ; i++) {
////            DeterministicLinearTimeSelection.linearTimeSelection(array2, i+1);
////        }
//        int linear = DeterministicLinearTimeSelection.linearTimeSelection(Arrays.copyOf(array2, array2.length), array2.length / 2);
//        endTime = System.currentTimeMillis();
//        System.out.println("Time taken by linear (" + linear + "): " + ((endTime - startTime)));
//
//        startTime = System.currentTimeMillis();
////        for(int i = 0 ; i < array2.length ; i++) {
////            SortingSelection.sortingSelection(array2, i+1);
////        }
//        int sorting = SortingSelection.sortingSelection(Arrays.copyOf(array2, array2.length), array2.length / 2);
//        endTime = System.currentTimeMillis();
//        System.out.println("Time taken by sorting (" + sorting + "): " +  ((endTime - startTime)));
//    }

    public static void main(String[] args) {
        int[] sizes = new int[] {100, 1000, 10000, 100000, 200000, 500000, 900000, 1000000, 2000000, 5000000, 9000000, 10000000, 20000000};
        int numberOfRuns = 20;
        long[][] results = new long[sizes.length][3];
        long start = 0, end = 0;
        for(int i = 0 ; i < sizes.length ; i++) {
            int size = sizes[i];
            int[] nums = HelpingFunctions.generateDistinctRandomArray(size, -size, size);
            long randomTime = 0, deterministicTime = 0, sortingTime = 0;

            for(int j = 0 ; j < numberOfRuns ; j++) {
                int[] randomCopy = Arrays.copyOf(nums, nums.length);
                int[] deterministicCopy = Arrays.copyOf(nums, nums.length);
                int[] sortingCopy = Arrays.copyOf(nums, nums.length);

                start = System.currentTimeMillis();
                int randomResult = RandomizedDivideANDConquer.randomizedSelection(randomCopy, randomCopy.length / 2);
                end = System.currentTimeMillis();
                randomTime += end - start;

                start = System.currentTimeMillis();
                int deterministicResult = DeterministicLinearTimeSelection.linearTimeSelection(deterministicCopy, deterministicCopy.length / 2);
                end = System.currentTimeMillis();
                deterministicTime += end - start;

                start = System.currentTimeMillis();
                int sortingResult = SortingSelection.sortingSelection(sortingCopy, sortingCopy.length / 2);
                end = System.currentTimeMillis();
                sortingTime += end - start;
            }

            results[i][0] = randomTime / numberOfRuns;
            results[i][1] = deterministicTime / numberOfRuns;
            results[i][2] = sortingTime / numberOfRuns;
        }
        printResults(sizes, results);
    }

    private static void printResults(int[] sizes, long[][] result) {
        for(int i = 0 ; i < sizes.length ; i++)
            System.out.println(sizes[i] + "\t" + result[i][0] + "\t" + result[i][1] + "\t" + result[i][2]);
    }
}
