package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Solver;
import model.SolverBFS;

class SolverBFSTest {

	@Test
	void test() {
		SolverBFS solver = new SolverBFS();
		solver.addGoal(55);
		solver.addDigit(1);
		solver.addDigit(2);
		solver.addDigit(4);
		solver.addDigit(5);
		solver.addDigit(10);
		solver.addDigit(25);
		solver.solve();
		//System.out.println(solver.totalCalls);
		System.out.println(solver.solution());
	}
}
