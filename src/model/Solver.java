package model;

import java.util.ArrayList;
import java.util.Stack;

public class Solver {
	public int totalCalls;
	int goal;
	boolean solved;
	Stack<Actions> solution;
	String out;
	ArrayList<Integer> digits;
	ArrayList<ArrayList<Integer>> stack;

	public Solver() {
		solution = new Stack<>();
		digits = new ArrayList<>();
		totalCalls = 0;
		out = "";
	}

	public void addGoal(int nextInt) {
		goal = nextInt;

	}

	public void addDigit(int nextInt) {
		digits.add(nextInt);

	}

	private boolean solve(ArrayList<Integer> attempt) {
		//totalCalls++;
		for (int x : attempt) {
			if (x == goal) {
				return true;
			}
		}
		int n = attempt.size();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				ArrayList<Integer> subset = new ArrayList<>();
				// add other numbers
				for (int k = 0; k < n; k++) {
					if (k != i && k != j) {
						subset.add(attempt.get(k));
					}
				}
				// do dfs
				if (attempt.get(j) != 0 && attempt.get(i) % attempt.get(j) == 0) {
					subset.add(attempt.get(i) / attempt.get(j));
					solution.push(new Actions(attempt.get(i), "/", attempt.get(j)));
					if (solve(subset)) {
						return true;
					}
					subset.remove(subset.size() - 1);
					solution.pop();
				}
				if (attempt.get(i) != 0 && attempt.get(j) % attempt.get(i) == 0) {
					subset.add(attempt.get(j) / attempt.get(i));
					solution.add(new Actions(attempt.get(j), "/", attempt.get(i)));
					if (solve(subset)) {
						return true;
					}
					subset.remove(subset.size() - 1);
					solution.pop();
				}
				if (attempt.get(j) - attempt.get(i) >= 0) {
					subset.add(attempt.get(j) - attempt.get(i));
					solution.add(new Actions(attempt.get(j), "-", attempt.get(i)));
					if (solve(subset)) {
						return true;
					}
					subset.remove(subset.size() - 1);
					solution.pop();
				}
				if (attempt.get(i) - attempt.get(j) >= 0) {
					subset.add(attempt.get(i) - attempt.get(j));
					solution.add(new Actions(attempt.get(i), "-", attempt.get(j)));
					if (solve(subset)) {
						return true;
					}
					subset.remove(subset.size() - 1);
					solution.pop();
				}

				subset.add(attempt.get(i) + attempt.get(j));
				solution.add(new Actions(attempt.get(i), "+", attempt.get(j)));
				if (solve(subset)) {
					return true;
				}
				subset.remove(subset.size() - 1);
				solution.pop();

				subset.add(attempt.get(i) * attempt.get(j));
				solution.add(new Actions(attempt.get(i), "*", attempt.get(j)));
				if (solve(subset)) {
					return true;
				}
				subset.remove(subset.size() - 1);
				solution.pop();
				// numbers at i and j are added, subbed, mult, div, then added

			}
		}
		return false;
	}

	public void solve() {
		solved = solve(digits);

	}

	public String solution() {
		if (out.length() > 0) {
			return out;
		}
		out = "";
		for (Actions action : solution) {
			out += action.toString();
		}
		return out;
	}
	public boolean solved() {
		return solved;
	}

}
