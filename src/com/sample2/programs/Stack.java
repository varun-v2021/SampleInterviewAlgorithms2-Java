
public class Stack {
	int size;
	int top;
	char arr[];

	public Stack(int n) {
		size = n;
		top = -1;
		arr = new char[n];
	}

	public boolean push(char x) {
		if (top < size) {
			top++;
			arr[top] = x;
			return true;
		} else {
			System.out.println("Stack Overflow detected");
			return false;
		}
	}

	public char pop() {
		char x = 0;
		if (top >= 0) {
			x = arr[top];
			--top;
			return x;
		} else {
			System.out.println("Stack underflow detected");
			return x;
		}
	}

	public boolean isEmpty() {
		return (top < 0);
	}
}
