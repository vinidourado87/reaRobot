package br.com.test.enums;

public enum FaceDirection {

	NORTH(Face.EAST, Face.WEST), 
	SOUTH(Face.WEST, Face.EAST), 
	EAST(Face.SOUTH, Face.NORTH),
	WEST(Face.NORTH, Face.SOUTH);
	
	private FaceDirection(Face right, Face left) {
		this.right = right;
		this.left = left;
	}

	private Face right;
	private Face left;

	public Face getRight() {
		return right;
	}
	public Face getLeft() {
		return left;
	}
}
