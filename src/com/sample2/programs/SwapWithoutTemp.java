
public class SwapWithoutTemp {
	//a=10, b=20
	public static void swap(int a, int b){
		System.out.println("Before swapping: a "+a + " b "+b);
		a = a + b; //30
		b = a - b; //30-20 = 10
		a = a - b; //30-10 = 20
		System.out.println("After swapping: a "+a + " b "+b);
	}
}
