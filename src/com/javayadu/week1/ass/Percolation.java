package com.javayadu.week1.ass;

import java.util.Arrays;
import java.lang.IllegalArgumentException;

public class Percolation {
	   
	   int[][][] grid;
	   int[][] grid_sz;
	   int[][] grid_full;
	   int no_of_open_sites = 0;
	   int grid_length = 0;
	   public Percolation(int n) {
		   // create n-by-n grid, with all sites blocked
		   grid_length = n;
		   grid = new int[n][n][2];
		   grid_sz = new int[n][n];
		   grid_full = new int[n][n];
		   
		   for(int i=0; i<n; i++) {
			   for(int j=0; j<n; j++) {
				   // initializing the 3D grid
				   grid[i][j][0] = -1;
				   grid[i][j][1] = -1;
				   // initializing the size and full arrays
				   grid_sz[i][j] = 1;
				   grid_full[i][j] = -1;
				  
			   }
		   }
	   }
	   public void open(int row, int col) throws java.lang.IllegalArgumentException{
		   // initial checks
		   if(row < 1 || col<1 || row > grid_length || col > grid_length )
			   throw new IllegalArgumentException();
		   else {
			   row--;
			   col--;
		   }
		   
		   
		   // open site (row, col) if it is not open already
		   if(!isOpen(row + 1,col + 1)){ // these methods are independent..can't just use them for this method.
			   //open the site....point the root to itself
			   grid[row][col][0] = row;
			   grid[row][col][1] = col;
			   no_of_open_sites++;
			   // if the site is in top row, mark it as full
			   if(row == 0)
				   grid_full[row][col] = 1;
		   
			   // Left right top bottom
			   //left
			   if(col != 0) {
				   if(isOpen(row+1,(col-1)+1)) {
					   connect(row,col,row,col-1);
				   }
			   }
			   //right
			   if(col < grid_length - 1 ) {
				   if(isOpen(row+1,(col+1)+1)) {
					   connect(row,col,row,col+1);
				   }
			   }
			   //top
			   if(row != 0) {
				   if(isOpen((row-1)+1,col+1)) {
					   connect(row,col,row-1,col);
				   }
			   }
			   //bottom
			   if(row < grid_length - 1) {
				   if(isOpen((row+1)+1,col+1)) {
					   connect(row,col,row+1,col);
				   }
			   }
			   
		   }
	   }
	   public boolean isOpen(int row, int col) throws java.lang.IllegalArgumentException{
		// initial checks
		   if(row < 1 || col<1 || row > grid_length || col > grid_length)
			   throw new IllegalArgumentException();
		   else {
			   row--;
			   col--;
		   }
		   // is site (row, col) open?
		// indices 0 and 1 both will be -1, checking anyone of them is enough
		   return grid[row][col][0] != -1;
		   
	   }
	   public boolean isFull(int row, int col) throws java.lang.IllegalArgumentException {
		// initial checks
		   if(row < 1 || col<1 || row > grid_length || col > grid_length )
			   throw new IllegalArgumentException();
		   else {
			   row--;
			   col--;
		   }
		   // is site (row, col) full?
		   if(!isOpen(row+1,col+1))
			   return false;
		   
		   int[] root_current = root(row,col);
		   int root_row = root_current[0];
		   int root_col = root_current[1];
		   
		   return grid_full[root_row][root_col] == 1;
	   }
	   public int numberOfOpenSites() {
		   // number of open sites
		   return no_of_open_sites;
	   }
	   public boolean percolates() {
		   // does the system percolate?
		   // if the last row is connected to the first row, system percolates
		   for(int i=0; i<grid_length; i++) {
			   if(isFull((grid_length-1)+1,i+1))
				   return true;
		   }
		   return false;
	   }
	   
	   private void connect(int r1, int c1, int r2, int c2) {
		   int[] root_r1c1 = root(r1,c1);
		   int[] root_r2c2 = root(r2,c2);
		   
		  if(!Arrays.equals(root_r1c1,root_r2c2)) {
			  if(grid_sz[root_r1c1[0]][root_r1c1[1]] > 
			  grid_sz[root_r2c2[0]][root_r2c2[1]]) {
				  //r1c1 is bigger tree
				  // change the root of r2c2 to r1c1
				  grid[root_r2c2[0]][root_r2c2[1]][0] = root_r1c1[0];
				  grid[root_r2c2[0]][root_r2c2[1]][1] = root_r1c1[1];
				  // modify the size of bigger tree
				  grid_sz[root_r1c1[0]][root_r1c1[1]] +=
						  grid_sz[root_r2c2[0]][root_r2c2[1]];
				  // marking as full
				  //if the smaller grid is full, convert the bigger to full
				  // if the bigger is full, it'll remain full
				  if(	grid_full[root_r2c2[0]][root_r2c2[1]] == 1 ) {
					  grid_full[root_r1c1[0]][root_r1c1[1]] = 1;
				  }
			  }
			  else {
				//r2c2 is bigger tree
				  // change the root of r1c1 to r2c2
				  grid[root_r1c1[0]][root_r1c1[1]][0] = root_r2c2[0];
				  grid[root_r1c1[0]][root_r1c1[1]][1] = root_r2c2[1];
				  // modify the size of bigger tree
				  grid_sz[root_r2c2[0]][root_r2c2[1]] +=
						  grid_sz[root_r1c1[0]][root_r1c1[1]];
				  // marking as full
				  //if the smaller grid is full, convert the bigger to full
				  // if the bigger is full, it'll remain full
				  if(	grid_full[root_r1c1[0]][root_r1c1[1]] == 1 ) {
					  grid_full[root_r2c2[0]][root_r2c2[1]] = 1;
				  }
			  }

		  }
		   
	   }
	   
	   private boolean isConnected(int r1, int c1, int r2, int c2) {
		   return Arrays.equals(root(r1,c1),root(r2,c2));
	   }
	   
	   private int count(int row, int col) {
		   return grid_sz[row][col];
	   }
	   
	   private int[] root(int row, int col) {
		   if(grid[row][col][0] == row && grid[row][col][1] == col) 
			   return new int[]{row,col};
			   // go to the root of the current index's root
		   return root(grid[grid[row][col][0]][grid[row][col][1]][0],
				   grid[grid[row][col][0]][grid[row][col][1]][1]);
	   }

	   public static void main(String[] args) {
		   // test client (optional)
		   Percolation p = new Percolation(3);
		   p.open(1,1);
		   p.open(2,1);
		   p.open(2,3);
		   
		   
		   
		   System.out.println(p.isFull(1, 1));
		   System.out.println(p.isFull(2, 1));
		   System.out.println(p.isFull(2, 3));

		   p.open(1,3);
		   System.out.println(p.isFull(1, 3));
		   
		   System.out.println(p.percolates());
		   
	   }
	}