package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Solver;

class SolverTest {

	@Test
	void test() {
		int j = 0;
		int n = 2000;
		for (int i = 0; i < n; i ++) {
		Solver solver = new Solver();
		solver.addGoal(i);
		solver.addDigit(1);
		solver.addDigit(2);
		solver.addDigit(4);
		solver.addDigit(5);
		solver.addDigit(10);
		solver.addDigit(25);
		solver.solve();
		//System.out.println(solver.totalCalls);
		System.out.println(solver.solution());
		if (solver.solved()) {
			j ++;
		}
		printProgressBar(i, n);
		}
		System.out.println(j);
		
	}
	public static void printProgressBar(int current, int end) {
	    int percent = (int) ((float) current / end * 100); // calculate percentage
	    int bars = percent / 2; // number of bars to draw (each bar represents 2%)
	    String progressBar = "[";

	    // add completed bars
	    for (int i = 0; i < bars; i++) {
	        progressBar += "=";
	    }

	    // add incomplete bars
	    for (int i = bars; i < 50; i++) {
	        progressBar += " ";
	    }

	    progressBar += "] " + percent + "%"; // add percentage

	    System.out.print("\r" + progressBar); // print progress bar on same line using carriage return
	    System.out.flush(); // flush output to ensure progress bar is displayed immediately
	}

}
