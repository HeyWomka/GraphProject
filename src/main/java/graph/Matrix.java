package graph;

import java.util.Scanner;

public class Matrix {
    private final int[][] mtrx;

    public Matrix(int v, int e) {
        mtrx = new int[v][e];
        fillZero();
    }

    public void fillZero() {
        for(int i = 0; i < getRows(); i++) {
            for(int j = 0; j < getCols(); j++) {
                mtrx[i][j] = 0;
            }
        }
    }

    public String toString(String caption) {
        StringBuilder res = new StringBuilder();
        res.append(caption).append("\n");
        for(int i = 0; i < getRows(); i++) {
            for(int j = 0; j < getCols(); j++) {
                res.append(mtrx[i][j]).append(',');
            }
            res.append('\n');
        }
        return res.toString();
    }

    public void showMatrix(String caption) {
        System.out.println("\n" + caption);
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                System.out.printf("%3d\t", mtrx[i][j]);
            }
            System.out.println();
        }

        System.out.print(toString("Спец. вывод: "));
    }

    public int getRows() {
        if (mtrx != null) return mtrx.length;
        return 0;
    }

    public int getCols() {
        return mtrx[0].length;
    }

    public static boolean isOrientedEdge() {
        System.out.print("=> Ориентированный? (y / n): ");
        Scanner in = new Scanner(System.in);
        String res = in.nextLine();
        return !res.equals("n");
    }

    public void addAdjacencyEdge(int v1, int v2, int weight, boolean oriented) {
        mtrx[v1][v2] = weight;
        mtrx[v2][v1] = oriented ? 0 : weight;
    }

    public void addIncidenceEdge(int v1, int v2, int e, int weight, boolean oriented) {
        mtrx[v1][e] = weight;
        mtrx[v2][e] = oriented ? weight * (-1) : weight;
    }
}
