package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Solver;

class SolverTest {

	@Test
	void test() {
		Solver solver = new Solver();
		solver.addGoal(55);
		solver.addDigit(1);
		solver.addDigit(2);
		solver.addDigit(4);
		solver.addDigit(5);
		solver.addDigit(10);
		solver.addDigit(25);
		solver.solve();
		System.out.println(solver.solution());
	}

}
