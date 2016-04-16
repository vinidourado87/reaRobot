package br.com.test.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTest {

	@Test
	public void validateSquareReport() {
		Square square = new Square(5, 5);
		assertThat("report method should return error message before place",
				square.getRobotReport(), equalTo("Robot not placed"));
	}

	@Test
	public void executeValidPlaceCommand() {
		Square square = new Square(5, 5);
		square.executeCommand("PLACE 2,2,EAST");
		assertThat("after execute PLACE, report should return the NEW state of robot",
				square.getRobotReport(), equalTo("2,2,EAST"));
	}

	@Test
	public void executeInvalidPlaceCommand() {
		Square square = new Square(5, 5);
		square.executeCommand("PLACE 2,2,EAST");
		square.executeCommand("PLACE 5,5,EAST");
		assertThat("after try to execute invalid PLACE, report should return the OLD state of robot",
				square.getRobotReport(), equalTo("2,2,EAST"));
	}

	@Test
	public void executeMoveCommand() {
		Square square = new Square(5, 5);
		square
			.executeCommand("PLACE 0,0,NORTH")
			.executeCommand("MOVE");
		assertThat("after execute MOVE, report should the position of moved robot",
				square.getRobotReport(), equalTo("0,1,NORTH"));
	}

	@Test
	public void executeLeftCommand() {
		Square square = new Square(5, 5);
		square
			.executeCommand("PLACE 0,0,NORTH")
			.executeCommand("LEFT");
		assertThat("after execute LEFT, report should the position of moved robot",
				square.getRobotReport(), equalTo("0,0,WEST"));
	}

	@Test
	public void executeRightCommand() {
		Square square = new Square(5, 5);
		square
			.executeCommand("PLACE 0,0,NORTH")
			.executeCommand("RIGHT");
		assertThat("after execute RIGHT, report should the position of moved robot",
				square.getRobotReport(), equalTo("0,0,EAST"));
	}

	@Test
	public void executeWrongCommand() {
		Square square = new Square(5, 5);
		square
			.executeCommand("PLACE 0,0,NORTH")
			.executeCommand("RIGHT")
			.executeCommand("DVFSDKFVBH")
			.executeCommand("WORNV ASDIUC A")
			.executeCommand("RIGHT")
			;
		assertThat("should ignore wrong commands and report the real position after that",
				square.getRobotReport(), equalTo("0,0,SOUTH"));
	}

	@Test
	public void executeMoveCommandOnTheBorder() {
		Square square = new Square(5, 5);
		square
			.executeCommand("PLACE 4,4,NORTH")
			.executeCommand("MOVE")
			;
		assertThat("should ignore MOVE command that will make the robot fall of",
				square.getRobotReport(), equalTo("4,4,NORTH"));
	}

	@Test
	public void executeListOfCommands() {
		Square square = new Square(5, 5);
		square
			.executeCommand("MOVE")
			.executeCommand("PLACE 4,4,NORTH")
			.executeCommand("MOVE")
			.executeCommand("RIGHT")
			.executeCommand("MOVE")
			.executeCommand("RIGHT")
			.executeCommand("MOVE")
			.executeCommand("LEFT")
			.executeCommand("MOVE")
		;
		assertThat("this list of commands should stop at 4,3,EAST",
				square.getRobotReport(), equalTo("4,3,EAST"));
	}

}
