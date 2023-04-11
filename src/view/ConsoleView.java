package view;

import java.util.Scanner;

import model.Solver;

public class ConsoleView {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Solver solver = new Solver();
		System.out.println("Enter goal number:");
		solver.addGoal(scanner.nextInt());
		System.out.println("Enter numbers:");
		while(scanner.hasNextInt()) {
			solver.addDigit(scanner.nextInt());
		}
		solver.solve();
		System.out.println(solver.solution());
		

	}

}
