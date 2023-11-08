import java.io.*;
import java.util.*;

public class MaxSideLength {
    public long solve(String inputFile) {
        long[][] points = getInput(inputFile);
        if(points == null) {
            System.out.println("Array is NULL.");
            return -1;
        }

        long[][] sortByX = copyArray(points), sortByY = copyArray(points);
        sortPoints(sortByX, false);
        sortPoints(sortByY, true);

        return findMaxSide(sortByX, sortByY, 0, sortByX.length - 1);
    }

    private long findMaxSide(long[][] sortedByX, long[][] sortedByY, int p, int q) {
        if(p >= q)
            return Long.MAX_VALUE;
        if(q - p == 1)
            return computeSide(sortedByX[p], sortedByX[q]);

        int r = (p + q) / 2;
        long[][] YLeft = getYPartition(sortedByY, sortedByX[r][0], true);
        long[][] YRight = getYPartition(sortedByY, sortedByX[r][0], false);
        long left = findMaxSide(sortedByX, YLeft, p, r);
        long right = findMaxSide(sortedByX, YRight, r + 1, q);
        long minSquare = Math.min(left, right);

        minSquare = Math.min(minSquare, combining(sortedByY, minSquare, sortedByX[r][0]));

        return minSquare;
    }

    private long combining(long[][] sortedByY, long minSquare, long x) {
        for(int i = 0 ; i < sortedByY.length ; i++) {
            if(sortedByY[i][0] <= x - minSquare) {
                for(int j = i ; j < i + 6 && j < sortedByY.length - 1; j++) {
                    minSquare = Math.min(minSquare, computeSide(sortedByY[j], sortedByY[j + 1]));
                }
            }
            if(sortedByY[i][0] >= x + minSquare){
                for(int j = i ; j < i + 6 && j < sortedByY.length - 1; j++) {
                    minSquare = Math.min(minSquare, computeSide(sortedByY[j], sortedByY[j + 1]));
                }
            }
        }
        return minSquare;
    }

    private long computeSide(long[] p1, long[] p2) {
        return Math.max(Math.abs(p1[0] - p2[0]), Math.abs(p1[1] - p2[1]));
    }
    private void sortPoints(long[][] array, boolean sortByY) {
        if(sortByY)
            Arrays.sort(array, (a, b) -> Long.compare(a[1], b[1]));
        else
            Arrays.sort(array, (a, b) -> Long.compare(a[0], b[0]));
    }

    private long[][] getYPartition(long[][] Y, long x, boolean left) {
        long[][] temp; int count = 0;
        if(left) {
            for(int i = 0 ; i < Y.length ; i++)
                if(Y[i][0] < x)
                    count++;
            temp = new long[count][2]; int index = 0;
            for(int i = 0 ; i < Y.length ; i++)
                if(Y[i][0] < x) {
                    temp[index][0] = Y[i][0];
                    temp[index][1] = Y[i][1];
                    index++;
                }
        }
        else {
            for(int i = 0 ; i < Y.length ; i++)
                if(Y[i][0] > x)
                    count++;
            temp = new long[count][2]; int index = 0;
            for(int i = 0 ; i < Y.length ; i++)
                if(Y[i][0] > x) {
                    temp[index][0] = Y[i][0];
                    temp[index][1] = Y[i][1];
                    index++;
                }
        }
        return temp;
    }

    private long[][] copyArray(long[][] array) {
        long[][] copied = new long[array.length][array[0].length];
        for(int i = 0 ; i < array.length ; i++) {
            for(int j = 0 ; j < array[0].length ; j++) {
                copied[i][j] = array[i][j];
            }
        }
        return copied;
    }

    private void printArray2D(long[][] array) {
        for(int i = 0 ; i < array.length ; i++) {
            for(int j = 0 ; j < array[i].length ; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private long[][] getInput(String filePath) {
        File inputFile = new File(filePath);

        if (!inputFile.exists()) {
            System.err.println("File not found: " + filePath);
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int numPoints = Integer.parseInt(reader.readLine());

            long[][] points = new long[numPoints][2];

            for (int i = 0; i < numPoints; i++) {
                String line = reader.readLine();
                if (line != null) {
                    String[] pointTokens = line.split(" ");
                    if (pointTokens.length == 2) {
                        points[i][0] = Long.parseLong(pointTokens[0]);
                        points[i][1] = Long.parseLong(pointTokens[1]);
                    } else {
                        System.err.println("Invalid format for point data on line " + (i + 2));
                        return null;
                    }
                } else {
                    System.err.println("File ended prematurely after " + i + " points.");
                    return null;
                }
            }
            return points;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return null;
        }
    }

//    public static void main(String[] args) {
//        String input = "test2.txt";
//        MaxSideLength obj = new MaxSideLength();
//        long start = System.currentTimeMillis();
//        System.out.println(obj.solve(input));
//        long end = System.currentTimeMillis();
//        System.out.println("Time: " + (end - start));
//        start = System.currentTimeMillis();
//        System.out.println(obj.getTest(input));
//        end = System.currentTimeMillis();
//        System.out.println("Time: " + (end - start));
//    }
//
//    public long getTest(String input) {
//        long result = Long.MAX_VALUE;
//        long[][] points = getInput(input);
//        for(int i = 0 ; i < points.length ; i++)
//            for(int j = i + 1 ; j < points.length ; j++)
//                result = Math.min(result, computeSide(points[i], points[j]));
//        return result;
//    }

}
