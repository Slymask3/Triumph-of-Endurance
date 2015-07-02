package com.abstractlabs.toe.utility;

import net.minecraft.block.Block;

import com.abstractlabs.toe.reference.Reference;

public class BlockTexture {
	private final String toe = Reference.MOD_ID + ":";
	
	private String top;
	private String bottom;
	private String left;
	private String right;
	private String front;
	private String back;
	
	public BlockTexture(String texture) {
		this.top = toe + texture;
		this.bottom = toe + texture;
		this.left = toe + texture;
		this.right = toe + texture;
		this.front = toe + texture;
		this.back = toe + texture;
	}
	
	public BlockTexture(String top, String bottom, String side) {
		this.top = toe + top;
		this.bottom = toe + bottom;
		this.left = toe + side;
		this.right = toe + side;
		this.front = toe + side;
		this.back = toe + side;
	}
	
	public BlockTexture(String top, String bottom, String left, String right, String front, String back) {
		this.top = toe + top;
		this.bottom = toe + bottom;
		this.left = toe + left;
		this.right = toe + right;
		this.front = toe + front;
		this.back = toe + back;
	}
	
	public BlockTexture(boolean useToeDir, String texture) {
		this.top = texture;
		this.bottom = texture;
		this.left = texture;
		this.right = texture;
		this.front = texture;
		this.back = texture;
	}
	
	public BlockTexture(boolean useToeDir, String top, String bottom, String side) {
		this.top = top;
		this.bottom = bottom;
		this.left = side;
		this.right = side;
		this.front = side;
		this.back = side;
	}
	
	public BlockTexture(boolean useToeDir, String top, String bottom, String left, String right, String front, String back) {
		this.top = top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
		this.front = front;
		this.back = back;
	}
	
	public BlockTexture(Block block) {
		this.top = block.getBlockTextureFromSide(1).getIconName();
		this.bottom = block.getBlockTextureFromSide(0).getIconName();
		this.left = block.getBlockTextureFromSide(2).getIconName();
		this.right = block.getBlockTextureFromSide(3).getIconName();
		this.front = block.getBlockTextureFromSide(4).getIconName();
		this.back = block.getBlockTextureFromSide(5).getIconName();
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