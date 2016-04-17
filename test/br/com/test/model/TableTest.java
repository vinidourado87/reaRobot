package br.com.test.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TableTest {

	@Test
	public void validateTableReport() {
		Table table = new Table(5, 5);

		assertThat("report method should return error message before place",
				table.getRobotReport(), equalTo("Robot not placed"));
	}

	@Test
	public void executeValidPlaceCommand() {
		Table table = new Table(5, 5)
			.executeCommand("PLACE 2,2,EAST");

		assertThat("after execute PLACE, report should return the NEW state of robot",
				table.getRobotReport(), equalTo("2,2,EAST"));
	}

	@Test
	public void executeValidPlaceCommandWithExtraWhiteSpaces() {
		Table table = new Table(5, 5)
			.executeCommand(" PLACE 2,2,EAST ");

		assertThat("after execute PLACE, report should return the NEW state of robot",
				table.getRobotReport(), equalTo("2,2,EAST"));
	}

	@Test
	public void executeInvalidPlaceCommand() {
		Table table = new Table(5, 5)
			.executeCommand("PLACE 2,2,EAST")
			.executeCommand("PLACE 5,5,EAST");

		assertThat("after try to execute an invalid PLACE, report should return the OLD state of robot",
				table.getRobotReport(), equalTo("2,2,EAST"));
	}

	@Test
	public void executeIncompletePlaceCommand() {
		Table table = new Table(5, 5)
			.executeCommand("PLACE 2,2,EAST")
			.executeCommand("PLACE 5,5");

		assertThat("after try to execute an invalid PLACE, report should return the OLD state of robot",
				table.getRobotReport(), equalTo("2,2,EAST"));
	}

	@Test
	public void executeIncorrectPlaceCommand() {
		Table table = new Table(5, 5)
			.executeCommand("PLACE 2,2,EAST")
			.executeCommand("PLACE5,5,EAST");

		assertThat("after try to execute an invalid PLACE, report should return the OLD state of robot",
				table.getRobotReport(), equalTo("2,2,EAST"));
	}

	@Test
	public void executeMoveCommand() {
		Table table = new Table(5, 5)
			.executeCommand("PLACE 0,0,NORTH")
			.executeCommand("MOVE");

		assertThat("after execute MOVE, report should return the new position of moved robot",
				table.getRobotReport(), equalTo("0,1,NORTH"));
	}

	@Test
	public void executeLeftCommand() {
		Table table = new Table(5, 5)
			.executeCommand("PLACE 0,0,NORTH")
			.executeCommand("LEFT");

		assertThat("after execute LEFT, report should return the new face of moved robot",
				table.getRobotReport(), equalTo("0,0,WEST"));
	}

	@Test
	public void executeRightCommand() {
		Table table = new Table(5, 5)
			.executeCommand("PLACE 0,0,NORTH")
			.executeCommand("RIGHT");

		assertThat("after execute RIGHT, report should return the new face of moved robot",
				table.getRobotReport(), equalTo("0,0,EAST"));
	}

	@Test
	public void executeWrongCommand() {
		Table table = new Table(5, 5)
			.executeCommand("PLACE 0,0,NORTH")
			.executeCommand("RIGHT")
			.executeCommand("DVFSDKFVBH")
			.executeCommand("WORNV ASDIUC A")
			.executeCommand("RIGHT");

		assertThat("should ignore wrong commands and report the real position after that",
				table.getRobotReport(), equalTo("0,0,SOUTH"));
	}

	@Test
	public void executeMoveCommandOnTheBorder() {
		Table table = new Table(5, 5)
			.executeCommand("PLACE 4,4,NORTH")
			.executeCommand("MOVE");

		assertThat("should ignore MOVE command that will make the robot fall of",
				table.getRobotReport(), equalTo("4,4,NORTH"));
	}

	@Test
	public void executeListOfCommands() {
		Table table = new Table(5, 5)
			.executeCommand("MOVE")
			.executeCommand("PLACE 4,4,NORTH")
			.executeCommand("MOVE")
			.executeCommand("RIGHT")
			.executeCommand("MOVE")
			.executeCommand("RIGHT")
			.executeCommand("MOVE")
			.executeCommand("LEFT")
			.executeCommand("MOVE");

		assertThat("this list of commands should stop at 4,3,EAST",
				table.getRobotReport(), equalTo("4,3,EAST"));
	}

}
