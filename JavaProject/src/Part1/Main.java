package Part1;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[] {6, 10, 13, 5, 8, 3, 2, 11, 12, 15, 200,1,1};
        for(int i = 0 ; i < array.length ; i++){
            System.out.println(RandomizedDivideANDConquer.randomizedSelection(array, i + 1) + " " +
                    DeterministicLinearTimeSelection.linearTimeSelection(array, i + 1) + " " +
                    SortingSelection.sortingSelection(array, i + 1));
        }
    }
}
