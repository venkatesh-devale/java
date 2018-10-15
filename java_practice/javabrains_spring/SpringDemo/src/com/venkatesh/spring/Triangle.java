package com.venkatesh.spring;

import java.util.List;

public class Triangle {
	
	private String type;
	private Point a;
	private Point b;
	private Point c;
	private List<Point> points;
	
	
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}

//	public Triangle(String type) {
//		this.type = type;
//	}
	
	public String getType() {  
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void draw() {
//		System.out.println("Point A: " + a.getX() + ", " + a.getY());
//		System.out.println("Point B: " + b.getX() + ", " + b.getY());
//		System.out.println("Point C: " + c.getX() + ", " + c.getY());
		
		for(Point point : points) {
			System.out.println("Point C: " + point.getX() + ", " + point.getY());
		}
	}

	
}
