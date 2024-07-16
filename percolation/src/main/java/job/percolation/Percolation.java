/*
package job.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final WeightedQuickUnionUF quickUnionUF;
    private final int n;
    private final int top;
    private final int bottom;
    private int numberOfOpenSite;
    private final Variable[][] matrix;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        int lengthOfRows = (n * n) + 2;
        this.n = n;
        matrix = new Variable[n][n];
        quickUnionUF = new WeightedQuickUnionUF(lengthOfRows);
        top = lengthOfRows - 1;
        bottom = lengthOfRows - 2;
        this.numberOfOpenSite = 0;
        for (int i = 0; i < n; i++) {
            Variable[] variables = new Variable[n];
            for (int j = 0; j < n; j++) {
                variables[j] = Variable.BLOCKED;
            }
            matrix[i] = variables;
        }

    }

    private int findTheIndex(int n, int row, int col) {
        if (row <= 0) {
            return col;
        }
        return n * row + col;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n)
            throw new IllegalArgumentException();
        int currentSite = findTheIndex(n, row, col);
        if (matrix[row][col].equals(Variable.OPEN)) return;
        if (row - 1 < 0) {
            quickUnionUF.union(top, currentSite);
        } else if (row + 1 >= n) {
            quickUnionUF.union(bottom, currentSite);
        }
        matrix[row][col] = Variable.OPEN;
        numberOfOpenSite++;
        toConnectTheSites(row, col);
    }

    private void toConnectTheSites(int row, int col) {
        int current = findTheIndex(n, row, col);
        int topValue = row - 1 < 0 ? current : findTheIndex(n, row - 1, col);
        int bottomValue = row + 1 >= n ? current : findTheIndex(n, row + 1, col);
        int leftValue = col - 1 < 0 ? current : findTheIndex(n, row, col - 1);
        int rightValue = col + 1 >= n ? current : findTheIndex(n, row, col + 1);
        if (row - 1 > -1 && isOpen(row - 1, col)) {
            quickUnionUF.union(topValue, current);
        }
        if (row + 1 < n && isOpen(row + 1, col)) {
            quickUnionUF.union(bottomValue, current);
        }
        if (col - 1 > -1 && isOpen(row, col - 1)) {
            quickUnionUF.union(leftValue, current);
        }
        if (col + 1 < n && isOpen(row, col + 1)) {
            quickUnionUF.union(rightValue, current);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            throw new IllegalArgumentException();
        }
        return !Variable.BLOCKED.equals(matrix[row][col]);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n)
            throw new IllegalArgumentException();
        return quickUnionUF.find(findTheIndex(n, row, col)) == top;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSite;
    }

    // does the system percolate?
    public boolean percolates() {
        return quickUnionUF.find(bottom) == quickUnionUF.find(top);
    }

    // test client (optional)
    public static void main(String[] args) {


    }
}
*/
