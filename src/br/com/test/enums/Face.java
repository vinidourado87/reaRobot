package br.com.test.enums;

public enum Face {

	NORTH(0, 1), 
	SOUTH(0, -1), 
	EAST(1, 0),
	WEST(-1, 0)
	;
	
	private Face(int x, int y) {
		this.incrementalX = x;
		this.incrementalY = y;
	}
	
	private int incrementalX;
	private int incrementalY;

	public int getIncrementalX() {
		return incrementalX;
	}
	public int getIncrementalY() {
		return incrementalY;
	}

}
