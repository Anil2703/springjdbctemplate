package com.anil.pack1;

public class Triangle {

	
	private int height;
	private String type;
	
	private String area;
	
	private Point pointA;
	
	
	
	public Triangle() {
		super();
	}


	public Point getPointA() {
		return pointA;
	}


	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public Triangle(int height, String type, String area) {
		super();
		this.height = height;
		this.type = type;
		this.area = area;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	

	public void PrintDimensions() {
		System.out.println("Triangle's Dimensions are printed as height="+getHeight()+" and of type="+getType()+" and area of"+getArea());
		System.out.println("The values of the Triangle points are: "+pointA.getA()+" and "+pointA.getB());
	}
}
