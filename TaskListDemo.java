package edu.orangecoastcollege.cs170.ctaylor82.ic25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskListDemo {

	public static void main(String[] args) {
		String name, date, deadline;
		int priority;
		Scanner cs = new Scanner(System.in);

		ArrayList<TaskList> Tasks = new ArrayList<>();

		File binaryfile = new File("Task.dat");

		System.out.println("Previously saved Tasks from binary file:");
		if (binaryfile.exists()) {
			try {
				ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryfile));
				Tasks = (ArrayList<TaskList>) fileReader.readObject();
				fileReader.close();
				for (TaskList task : Tasks)
					System.out.println(task);
			} catch (IOException | ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} else
			System.out.println("[None, please enter new Tasks]");

		do {
			System.out.println("\nPlease enter task name (or \"quit\" to exit): ");
			name = cs.nextLine();
			if (name.equals("quit"))
				break;
			System.out.println("Please enter due date (in form MM/DD/YYYY): ");
			date = cs.nextLine();
			System.out.println("Please enter deadline: ");
			deadline = cs.nextLine();
			System.out.println("Please enter priority: ");
			priority = cs.nextInt();

			cs.nextLine();
			Tasks.add(new TaskList(name, date, deadline, priority));

		} while (!name.equals("quit"));
		cs.close();

		try {
			ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryfile));
			fileWriter.writeObject(Tasks);
			fileWriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
