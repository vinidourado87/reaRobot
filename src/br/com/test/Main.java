package br.com.test;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import br.com.test.model.Table;

public class Main {

	public static void main(String[] args) {
		try {
			//Integer x = Integer.parseInt(JOptionPane.showInputDialog("Type the size of X"));
			//Integer y = Integer.parseInt(JOptionPane.showInputDialog("Type the size of Y"));
			Table table = new Table(5, 5);

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showDialog(null, "Select");
			FileReader fileReader = new FileReader(fileChooser.getSelectedFile());
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();

			while (line != null) {
				table.executeCommand(line);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "FILE NOT FOUND", "ERROR", ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR!", "ERROR", ERROR_MESSAGE);
		}
	}
}
