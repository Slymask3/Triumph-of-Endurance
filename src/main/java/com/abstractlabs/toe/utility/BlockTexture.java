package com.abstractlabs.toe.utility;

public class BlockTexture {
	private String top;
	private String bottom;
	private String left;
	private String right;
	private String front;
	private String back;
	
	public BlockTexture(String texture) {
		this.top = texture;
		this.bottom = texture;
		this.left = texture;
		this.right = texture;
		this.front = texture;
		this.back = texture;
	}
	
	public BlockTexture(String top, String bottom, String side) {
		this.top = top;
		this.bottom = bottom;
		this.left = side;
		this.right = side;
		this.front = side;
		this.back = side;
	}
	
	public BlockTexture(String top, String bottom, String left, String right, String front, String back) {
		this.top = top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
		this.front = front;
		this.back = back;
	}
	
	public String getTop() {
		return top;
	}
	
	public String getBottom() {
		return bottom;
	}
	
	public String getLeft() {
		return left;
	}
	
	public String getRight() {
		return right;
	}
	
	public String getFront() {
		return front;
	}
	
	public String getBack() {
		return back;
	}
}