package Part1;
import org.junit.*;
import java.util.Arrays;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class TestCases {
    int[] sizes = new int[] {100, 1000, 10000, 100000, 500000, 1000000, 5000000, 10000000};
    @Test
    public void Test0() {
        int testNumber = 0;
        int[] array = HelpingFunctions.generateDistinctRandomArray(sizes[testNumber], -sizes[testNumber], sizes[testNumber]);
        int randomResult = RandomizedDivideANDConquer.randomizedSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int deterministicResult = DeterministicLinearTimeSelection.linearTimeSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int sortingResult = SortingSelection.sortingSelection(Arrays.copyOf(array, array.length), array.length / 2);
        assertEquals(randomResult, deterministicResult);
        assertEquals(deterministicResult, sortingResult);
    }

    @Test
    public void Test1() {
        int testNumber = 1;
        int[] array = HelpingFunctions.generateDistinctRandomArray(sizes[testNumber], -sizes[testNumber], sizes[testNumber]);
        int randomResult = RandomizedDivideANDConquer.randomizedSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int deterministicResult = DeterministicLinearTimeSelection.linearTimeSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int sortingResult = SortingSelection.sortingSelection(Arrays.copyOf(array, array.length), array.length / 2);
        assertEquals(randomResult, deterministicResult);
        assertEquals(deterministicResult, sortingResult);
    }

    @Test
    public void Test2() {
        int testNumber = 2;
        int[] array = HelpingFunctions.generateDistinctRandomArray(sizes[testNumber], -sizes[testNumber], sizes[testNumber]);
        int randomResult = RandomizedDivideANDConquer.randomizedSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int deterministicResult = DeterministicLinearTimeSelection.linearTimeSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int sortingResult = SortingSelection.sortingSelection(Arrays.copyOf(array, array.length), array.length / 2);
        assertEquals(randomResult, deterministicResult);
        assertEquals(deterministicResult, sortingResult);
    }

    @Test
    public void Test3() {
        int testNumber = 3;
        int[] array = HelpingFunctions.generateDistinctRandomArray(sizes[testNumber], -sizes[testNumber], sizes[testNumber]);
        int randomResult = RandomizedDivideANDConquer.randomizedSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int deterministicResult = DeterministicLinearTimeSelection.linearTimeSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int sortingResult = SortingSelection.sortingSelection(Arrays.copyOf(array, array.length), array.length / 2);
        assertEquals(randomResult, deterministicResult);
        assertEquals(deterministicResult, sortingResult);
    }

    @Test
    public void Test4() {
        int testNumber = 4;
        int[] array = HelpingFunctions.generateDistinctRandomArray(sizes[testNumber], -sizes[testNumber], sizes[testNumber]);
        int randomResult = RandomizedDivideANDConquer.randomizedSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int deterministicResult = DeterministicLinearTimeSelection.linearTimeSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int sortingResult = SortingSelection.sortingSelection(Arrays.copyOf(array, array.length), array.length / 2);
        assertEquals(randomResult, deterministicResult);
        assertEquals(deterministicResult, sortingResult);
    }

    @Test
    public void Test5() {
        int testNumber = 5;
        int[] array = HelpingFunctions.generateDistinctRandomArray(sizes[testNumber], -sizes[testNumber], sizes[testNumber]);
        int randomResult = RandomizedDivideANDConquer.randomizedSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int deterministicResult = DeterministicLinearTimeSelection.linearTimeSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int sortingResult = SortingSelection.sortingSelection(Arrays.copyOf(array, array.length), array.length / 2);
        assertEquals(randomResult, deterministicResult);
        assertEquals(deterministicResult, sortingResult);
    }

    @Test
    public void Test6() {
        int testNumber = 6;
        int[] array = HelpingFunctions.generateDistinctRandomArray(sizes[testNumber], -sizes[testNumber], sizes[testNumber]);
        int randomResult = RandomizedDivideANDConquer.randomizedSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int deterministicResult = DeterministicLinearTimeSelection.linearTimeSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int sortingResult = SortingSelection.sortingSelection(Arrays.copyOf(array, array.length), array.length / 2);
        assertEquals(randomResult, deterministicResult);
        assertEquals(deterministicResult, sortingResult);
    }

    @Test
    public void Test7() {
        int testNumber = 7;
        int[] array = HelpingFunctions.generateDistinctRandomArray(sizes[testNumber], -sizes[testNumber], sizes[testNumber]);
        int randomResult = RandomizedDivideANDConquer.randomizedSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int deterministicResult = DeterministicLinearTimeSelection.linearTimeSelection(Arrays.copyOf(array, array.length), array.length / 2);
        int sortingResult = SortingSelection.sortingSelection(Arrays.copyOf(array, array.length), array.length / 2);
        assertEquals(randomResult, deterministicResult);
        assertEquals(deterministicResult, sortingResult);
    }
}
