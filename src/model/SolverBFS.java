package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class SolverBFS {
	int goal;
	Stack<Actions> solution;
	ArrayList<Integer> digits;
	Queue<ArrayList<Integer>> queue;
	Queue<ArrayList<Actions>> actionQueue;

	public SolverBFS() {
		solution = new Stack<>();
		digits = new ArrayList<>();
		queue = new ArrayDeque<>();
		actionQueue = new ArrayDeque<>();
		
	}

	public void addGoal(int nextInt) {
		goal = nextInt;

	}

	public void addDigit(int nextInt) {
		digits.add(nextInt);

	}
	/***
	 * adds action to queue, add resulting set to queue as well
	 */
	private void addOption(ArrayList<Actions> action, ArrayList<Integer> attempt) {
		queue.add(attempt);
		actionQueue.add(action);
	}
	private boolean isSolution(ArrayList<Integer> attempt) {
		for (int x : attempt) {
			if (x == goal) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private boolean solve1() {
		ArrayList<Integer> attempt = queue.poll();
		ArrayList<Actions> actions = actionQueue.poll();
		if (attempt == null) {
			return false;
		}
		while (attempt != null 
				&& !isSolution(attempt)) {
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
					if (attempt.get(j) != 0 && attempt.get(i) % attempt.get(j) == 0) {
						subset.add(attempt.get(i) / attempt.get(j));
						actions.add(new Actions(attempt.get(i), "/", attempt.get(j)));
						// not best practice
						addOption((ArrayList<Actions>) actions.clone(), (ArrayList<Integer>)subset.clone());
						subset.remove(subset.size() - 1);
						actions.remove(actions.size() - 1);
					}
					if (attempt.get(i) != 0 && attempt.get(j) % attempt.get(i) == 0) {
						subset.add(attempt.get(j) / attempt.get(i));
						actions.add(new Actions(attempt.get(j), "/", attempt.get(i)));
						addOption((ArrayList<Actions>) actions.clone(), (ArrayList<Integer>)subset.clone());
						subset.remove(subset.size() - 1);
						actions.remove(actions.size() - 1);
					}
					if (attempt.get(j) - attempt.get(i) >= 0) {
						subset.add(attempt.get(j) - attempt.get(i));
						actions.add(new Actions(attempt.get(j), "-", attempt.get(i)));
						addOption((ArrayList<Actions>) actions.clone(), (ArrayList<Integer>)subset.clone());
						subset.remove(subset.size() - 1);
						actions.remove(actions.size() - 1);
					}
					if (attempt.get(i) - attempt.get(j) >= 0) {
						subset.add(attempt.get(i) - attempt.get(j));
						actions.add(new Actions(attempt.get(i), "-", attempt.get(j)));
						addOption((ArrayList<Actions>) actions.clone(), (ArrayList<Integer>)subset.clone());
						subset.remove(subset.size() - 1);
						actions.remove(actions.size() - 1);
					}

					subset.add(attempt.get(i) + attempt.get(j));
					actions.add(new Actions(attempt.get(i), "+", attempt.get(j)));
					addOption((ArrayList<Actions>) actions.clone(), (ArrayList<Integer>)subset.clone());
					subset.remove(subset.size() - 1);
					actions.remove(actions.size() - 1);

					subset.add(attempt.get(i) * attempt.get(j));
					actions.add(new Actions(attempt.get(i), "*", attempt.get(j)));
					addOption((ArrayList<Actions>) actions.clone(), (ArrayList<Integer>)subset.clone());
					subset.remove(subset.size() - 1);
					actions.remove(actions.size() - 1);
					// numbers at i and j are added, subbed, mult, div, then added
                    
					
				}
			}
			attempt = queue.poll();
			actions = actionQueue.poll();
		}
		
		solution.addAll(actions);
		return true;
	}

	public void solve() {
		queue.add(digits);
		actionQueue.add(new ArrayList<Actions>());
		solve1();

	}

	public String solution() {
		String out = "";
		for (Actions action : solution) {
			out += action.toString();
		}
		return out;
	}

	public static ArrayList<ArrayList<Integer>> subsetsOfSizeTwo(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int n = set.size();

		return result;
	}
}
