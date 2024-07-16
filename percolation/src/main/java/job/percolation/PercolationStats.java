/*
package job.percolation;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double[] results;

    private final int n;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        results = new double[trials];
        this.n = n;
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(double mean, double dev, int n, double confLevVal) {
        return mean - confLevVal * (dev / Math.sqrt(n));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(double mean, double dev, int n, double confLevVal) {
        return mean + confLevVal * (dev / Math.sqrt(n));
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats percolationStats = new PercolationStats(StdIn.readInt(), StdIn.readInt());
        Percolation percolation = new Percolation(percolationStats.n);
        int len = percolationStats.results.length;
        for (int i = 0; i < len; i++) {
            boolean percolates = percolation.percolates();
            while (!percolates) {
                percolation.open(StdRandom.uniformInt(percolationStats.n), StdRandom.uniformInt(percolationStats.n));
                percolates = percolation.percolates();
            }
            percolationStats.results[i] = ((double) percolation.numberOfOpenSites()) / ( percolationStats.n * percolationStats.n);
            percolation = new Percolation(percolationStats.n);
        }
        double mean = percolationStats.mean();
        double dev = percolationStats.stddev();
        double confLevVal = 0.95;
        double confLo = percolationStats.confidenceLo(mean, dev, percolationStats.n, confLevVal);
        double confHi = percolationStats.confidenceHi(mean, dev, percolationStats.n, confLevVal);
        StdOut.print("mean                         =   ");
        StdOut.print(mean);
        StdOut.println();
        StdOut.print("dev                          =   ");
        StdOut.print(dev);
        StdOut.println();
        StdOut.print("95% confidence interval      =   ");
        StdOut.print("[ ");
        StdOut.print(confLo);
        StdOut.print(", ");
        StdOut.print(confHi);
        StdOut.print(" ]");
        StdOut.println();

    }

}*/
