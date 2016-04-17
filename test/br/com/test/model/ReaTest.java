package br.com.test.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ReaTest {

	private Table table;

	@Before
	public void setUp() {
		table = new Table(5, 5);
	}

	@Test
	public void testExampleA() {
		table
			.executeCommand("PLACE 0,0,NORTH")
			.executeCommand("MOVE");
		assertThat(table.getRobotReport(), equalTo("0,1,NORTH"));
	}

	@Test
	public void testExampleB() {
		table
			.executeCommand("PLACE 0,0,NORTH")
			.executeCommand("LEFT");
		assertThat(table.getRobotReport(), equalTo("0,0,WEST"));
	}

	@Test
	public void testExampleC() {
		table
			.executeCommand("PLACE 1,2,EAST")
			.executeCommand("MOVE")
			.executeCommand("MOVE")
			.executeCommand("LEFT")
			.executeCommand("MOVE");
		assertThat(table.getRobotReport(), equalTo("3,3,NORTH"));
	}

}
