package com.javayadu.week3.ass;

import java.util.ArrayList;
import java.util.List;

public class BruteCollinearPoints {
	List<LineSegment> segs = new ArrayList<LineSegment>(); 
	   public BruteCollinearPoints(Point[] points)  {
		   // finds all line segments containing 4 points
		   
		   for(int i=0; i < points.length; i++) {
			   for(int j=i+1; j < points.length; j++) {
				   for(int k=j+1; k < points.length; k++) {
					   for(int l=k+1; l<points.length; l++) {
						   if(points[i].slopeTo(points[j]) == points[i].slopeTo(points[k])) {
							   if(points[i].slopeTo(points[k]) == points[i].slopeTo(points[l])) {
								   segs.add(new LineSegment(points[i],points[l]));
							   }
						   }
					   }
				   }
			   }
		   }
	   }
	   public int numberOfSegments()      {
		   // the number of line segments
		   return segs.size();
	   }
	   public LineSegment[] segments()      {
		   // the line segments
		   LineSegment[] lsarr = new LineSegment[segs.size()];
		   return segs.toArray(lsarr);
	   }
	   
	   public static void main(String[] args) {
		    Point p1 = new Point(3,2);
	    	Point p2 = new Point(5,4);
	    	Point p3 = new Point(7,6);
	    	Point p4 = new Point(9,8);
	    	Point p5 = new Point(20,8);
	    	Point p6 = new Point(21,9);
	    	Point p7 = new Point(22,10);
	    	Point p8 = new Point(23,11);
	    	
	    	Point[] parr = {p1,p2,p3,p4,p5,p6,p7,p8};
	    	BruteCollinearPoints bcp = new BruteCollinearPoints(parr);
	    	display(bcp.segments());
	    	
	   }
	   private static void display(Object[] arr) {
			for(Object elmt: arr) {
				System.out.println(elmt + " ");
			}
			System.out.println(" ");
		}
	}


