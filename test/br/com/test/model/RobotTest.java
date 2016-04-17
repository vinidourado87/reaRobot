package br.com.test.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import br.com.test.enums.Face;

public class RobotTest {

	@Test
	public void givenRobot() {
		Robot robot = new Robot(1, 1, Face.WEST);

		assertThat("report method should return the actual state of robot",
				robot.getReport(), equalTo("1,1,WEST"));
	}

	@Test
	public void givenRobotThenMoveToNorth() {
		Robot robot = new Robot(1, 1, Face.NORTH);
		robot.move();

		assertThat("keep the value of x and plus 1 to y",
				robot.getReport(), equalTo("1,2,NORTH"));
	}

	@Test
	public void givenRobotThenChangeDirectionToRight() {
		Robot robot = new Robot(1, 1, Face.NORTH);
		robot.right();

		assertThat("keep the value of x and Y, change face to EAST",
				robot.getReport(), equalTo("1,1,EAST"));
	}

	@Test
	public void givenRobotThenChangeDirectionToLeft() {
		Robot robot = new Robot(1, 1, Face.NORTH);
		robot.left();

		assertThat("keep the value of x and y, change face to WEST",
				robot.getReport(), equalTo("1,1,WEST"));
	}

	@Test
	public void givenRobotThenMoveToSouth() {
		Robot robot = new Robot(1, 1, Face.SOUTH);
		robot.move();

		assertThat("keep the value of x and subs 1 from y",
				robot.getReport(), equalTo("1,0,SOUTH"));
	}

	@Test
	public void givenRobotThenMoveToEast() {
		Robot robot = new Robot(1, 1, Face.EAST);
		robot.move();

		assertThat("plus 1 to x and keep the value of y",
				robot.getReport(), equalTo("2,1,EAST"));
	}

	@Test
	public void givenRobotThenMoveToWest() {
		Robot robot = new Robot(1, 1, Face.WEST);
		robot.move();

		assertThat("subs 1 to x and keep the value of y",
				robot.getReport(), equalTo("0,1,WEST"));
	}
}
