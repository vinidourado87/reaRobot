package br.com.test.model;

import br.com.test.enums.Face;
import br.com.test.enums.FaceDirection;

public class Robot {

	private int x, y;
	private Face face;
	
	public Robot(int x, int y, Face face) {
		this.x = x;
		this.y = y;
		this.face = face;
	}
	
	public Robot stepForward() {
		this.y += face.getIncrementalY();
		this.x += face.getIncrementalX();
		return this;
	}
	
	public Robot stepBack() {
		this.y -= face.getIncrementalY();
		this.x -= face.getIncrementalX();
		return this;
	}
	
	public void right() {
		face = FaceDirection.valueOf(face.name()).getRight();
	}

	public void left() {
		face = FaceDirection.valueOf(face.name()).getLeft();
	}
	
	public String getReport() {
		return x + "," + y + "," + face.toString();
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Face getFace() {
		return face;
	}
	public void setFace(Face face) {
		this.face = face;
	}
}
