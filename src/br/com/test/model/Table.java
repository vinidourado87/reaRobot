package br.com.test.model;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

import javax.swing.JOptionPane;

import br.com.test.enums.Face;

public class Table {

	private int x, y;
	private Robot robot;

	public Table(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String getRobotReport() {
		return robot == null ? "Robot not placed" : robot.getReport();
	}

	public Table executeCommand(String command) {
		command = command.trim();
		if (command.startsWith("PLACE")) {
			placeRobot(command);
		} else if(robot != null) {
			commandOnPlacedRobot(command);
		}
		return this;
	}

	private void placeRobot(String command) {
		String[] values = extractValues(command);
		if (canPlaceRobot(values)) robot = new Robot(getNewXOf(values), getNewYOf(values), getNewFaceOf(values));
	}

	private void commandOnPlacedRobot(String command) {
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
			JOptionPane.showMessageDialog(null, getRobotReport(), "REPORT", INFORMATION_MESSAGE);
			break;
		default:
			break;
		}
	}

	private void moveRobot() {
		if ( !robotIsGoingToFall() ) robot.move();
	}

	private boolean robotIsGoingToFall() {
		return robot.getX() + robot.getFace().getIncrementalX() >= this.x || 
				robot.getY() + robot.getFace().getIncrementalY() >= this.y;
	}

	private boolean canPlaceRobot(String[] values) {
		return values != null && (getNewXOf(values) < x && getNewYOf(values) < y && getNewFaceOf(values) != null);
	}

	private Integer getNewXOf(String[] values) {
		return Integer.valueOf(values[0]);
	}

	private Integer getNewYOf(String[] values) {
		return Integer.valueOf(values[1]);
	}

	private Face getNewFaceOf(String[] values) {
		return Face.valueOf(values[2]);
	}

	private String[] extractValues(String command) {
		String[] splitCommand = command.split(" ");
		return splitCommand.length == 2 ? splitCommand[1].split(",") : null;
	}

}
