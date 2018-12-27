package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        String[] location = new String[n];
        int[][] mark = new int[n][n];

        for (int i = 0; i < n; i++) {
            String tempLo = "";
            for (int j = 0; j < n; j++) {
                mark[i][j] = 0;
                tempLo = tempLo + ".";
            }
            location[i] = tempLo;
        }
        generate(0, n, location, result, mark);
        return result;
    }

    void generate(int k, int n,  String[]  location, List<List<String>> result, int[][] mark) {
        if (k >= n) {

            List<String> LocationList = Arrays.asList(deepCopySingle(location));
            result.add(LocationList);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (mark[k][i] == 0) {
                int[][] tempMark;
                int[][] layerMark;
                //System.arraycopy(mark, 0, tempMark, 0, n);
                //System.arraycopy(mark, 0, layerMark, 0, n);
                tempMark = deepCopy(mark);
                //layerMark = deepCopy(mark);
                String tempLo = new String(location[k]);
                StringBuilder builder = new StringBuilder(location[k]);
                builder.replace(i,i+1, "Q");
                location[k] = builder.toString();
                updateMark(mark, k, i);
                generate(k + 1, n, location, result, mark);
                mark = tempMark;
                location[k] = tempLo;
            }
        }
    }


    // update mark
    public void updateMark(int[][] mark, int x, int y) {
        int[] directionX = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] directionY = {-1, 0, 1, -1, 1, -1, 0, 1};

        mark[x][y] = 1;
        for (int i = 1; i <mark.length; i++) {
            for (int j = 0; j < 8; j++) {
                int newX = x + i*directionX[j];
                int newY = y + i*directionY[j];

                if (newX < mark.length && newY < mark.length && newX >= 0 && newY>= 0) {
                    mark[newX][newY] = 1;
                }
            }
        }
    }

    public static int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    public static String[] deepCopySingle(String[] original) {
        String[] nv = new String[original.length];
        for (int i = 0; i < nv.length; i++) {
            nv[i] = original[i];
        }
        return  nv;
    }




    public static void main(String[] args) {
        NQueens queens = new NQueens();
        queens.solveNQueens(8);
    }

}
