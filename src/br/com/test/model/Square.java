package br.com.test.model;

import br.com.test.enums.Face;

public class Square {

	private int x, y;
	private Robot robot;

	public Square(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Square executeCommand(String command) {
		if (command.startsWith("PLACE")) {
			placeRobot(command);
		} else if(robot != null) {
			execute(command);
		}
		return this;
	}

	private void placeRobot(String command) {
		String[] values = extractValues(command);
		if (canPlaceRobot(values)) {
			robot = new Robot(getNewX(values), getNewY(values), getNewFace(values));
		}
	}

	private void execute(String command) {
		switch (command) {
		case "MOVE" :
			moveRobot();
			break;
		case "LEFT" :
			robot.left();
			break;
		case "RIGHT" :
			robot.right();
			break;
		case "REPORT" :
			System.out.println(getRobotReport());
			break;
		default:
			break;
		}
	}

	private void moveRobot() {
		robot.stepForward();
		if ( robotIsGoingToFall() ) robot.stepBack();
	}

	private boolean robotIsGoingToFall() {
		return robot.getX() >= this.x || robot.getY() >= this.y;
	}

	private boolean canPlaceRobot(String[] values) {
		return getNewX(values) < x && getNewY(values) < y && getNewFace(values) != null; 
	}

	private Integer getNewX(String[] values) {
		return Integer.valueOf(values[0]);
	}

	private Integer getNewY(String[] values) {
		return Integer.valueOf(values[1]);
	}

	private Face getNewFace(String[] values) {
		return Face.valueOf(values[2]);
	}

	private String[] extractValues(String command) {
		return command.split(" ")[1].split(",");
	}

	public String getRobotReport() {
		return robot == null ? null : robot.getReport();
	}
}
