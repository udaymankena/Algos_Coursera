//package com.javayadu.week1.ass;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {
	private final double[] trial_thresh;
	private final double CONFIDENCE_CONSTANT = 1.96;
	   public PercolationStats(int n, int trials)  {
		   // perform trials independent experiments on an n-by-n grid
		   if(n <= 0 || trials <= 0)
			   throw new java.lang.IllegalArgumentException();
		   trial_thresh = new double[trials];
		   double perc_threshold = 0.0;
		   for(int trial=0;trial<trials;trial++) {
			   Percolation perc = new Percolation(n);
			   while(!perc.percolates()) {
				   int a = StdRandom.uniform(1, n+1);
				   int b = StdRandom.uniform(1, n+1);
				   //System.out.println(a + "," + b);
				   perc.open(a,b);
			   }
			   //System.out.println("perc.numberOfOpenSites():" + perc.numberOfOpenSites());
			   perc_threshold = (double)perc.numberOfOpenSites()/(n*n);
			   //System.out.println("threshold: " + perc_threshold);
			   trial_thresh[trial] = perc_threshold;
			   }
	   }
	   public double mean() {
		   // sample mean of percolation threshold
		   return StdStats.mean(trial_thresh);
	   }
	   public double stddev() {
		   // sample standard deviation of percolation threshold
		   /*double st_dev_sum = 0;
		   double mean = mean();
		   for(int i=0; i<trial_thresh.length; i++) {
			  st_dev_sum +=  (mean-trial_thresh[i])*(mean-trial_thresh[i]);
		   }
		   return Math.sqrt(st_dev_sum/(trial_thresh.length - 1)); */
		   return StdStats.stddev(trial_thresh);
	   }
	   public double confidenceLo() {
		   // low  endpoint of 95% confidence interval
		   double sqrt_trials = Math.sqrt(trial_thresh.length);
		   return  mean() - (CONFIDENCE_CONSTANT * stddev())/sqrt_trials;
	   }
	   public double confidenceHi() {
		   // high endpoint of 95% confidence interval
		   double sqrt_trials = Math.sqrt(trial_thresh.length);
		   return  mean() + (CONFIDENCE_CONSTANT * stddev())/sqrt_trials;
	   }

	   public static void main(String[] args) {
		   // test client (described below)
		   int n = Integer.parseInt(args[0]);
		   int trials = Integer.parseInt(args[1]);
		   
		   PercolationStats ps = new PercolationStats(n, trials);
		   System.out.println("mean                    = " + ps.mean());
		   System.out.println("stddev                  = " + ps.stddev());
		   System.out.println("95% confidence interval = " + "[" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]" );
	   }
	}
