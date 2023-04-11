package view;

import java.util.Scanner;

import model.SolverBFS;

public class ConsoleViewBFS {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SolverBFS solver = new SolverBFS();
		System.out.println("Enter goal number:");
		solver.addGoal(scanner.nextInt());
		System.out.println("Enter numbers (enter done when done):");
		while(scanner.hasNextInt()) {
			solver.addDigit(scanner.nextInt());
		}
		solver.solve();
		System.out.println(solver.solution());
		

	}

}
