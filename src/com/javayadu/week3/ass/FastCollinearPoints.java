package com.javayadu.week3.ass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {
	
	List<LineSegment> segs;
	
	   public FastCollinearPoints(Point[] points) {
		   // finds all line segments containing 4 or more points
		   segs = new ArrayList<LineSegment>();
		 //Sort the points based on the natural order
		   Arrays.sort(points);
		   Point[] points_sorted = points;
		   for(int i=0; i<points.length; i++) {
			   Point current = points[i];
			   points = points_sorted;
			   Arrays.sort(points,points[i].slopeOrder());
			   //identify the line segments
			   int seg_len = 1;
			   Point seg_start = null;
			   for(int j=1; j<points.length-1; j++) {
				   if(current.slopeTo(points[j]) == current.slopeTo(points[j+1])) {
					   if(seg_len == 1)
						   seg_start = points[j];
					   seg_len++;
				   }
				   else if(j == points.length - 2) {
					   if(seg_len >= 4) {
						   segs.add(new LineSegment(seg_start, points[j+1]));
					   }
				   }
				   else {
					   if(seg_len >= 4) {
						   segs.add(new LineSegment(seg_start, points[j]));
					   }
					   
					   seg_len = 1;
				   }
			   }
		   }
		   
	   }
	   public int numberOfSegments() {
		   // the number of line segments
		   return 0;
	   }
	   public LineSegment[] segments() {
		   // the line segments
		   return null;
	   }
	   
	   private boolean seg_eql(LineSegment l1, LineSegment l2) {
		   return l1.toString() == l2.toString();
	   }
	   
	   private void rem_dup_segs() {
		
	   }
	   
	   
	   
	   public static void main(String[] args) {
		   String str = "abc";
		   String str2 = str + "def";
		   str = "pqr";
		   System.out.println(str2);
	   }
	}