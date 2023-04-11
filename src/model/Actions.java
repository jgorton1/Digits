package model;

public class Actions {
    int first, last;
    String op;
	public Actions(Integer integer, String string, Integer integer2) {
		first = integer;
		op = string;
		last = integer2;
	}
	public String toString() {
		return first + op + last + "\n";
	}

}
