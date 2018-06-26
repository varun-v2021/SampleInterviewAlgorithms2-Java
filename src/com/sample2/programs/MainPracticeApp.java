import java.util.HashSet;

public class MainPracticeApp {

	public static HashSet<String> getAllPermutations(String str) {
		HashSet<String> permutations = new HashSet<>();
		if (str == null || str.length() == 0) {
			permutations.add("");
			return permutations;
		}

		char first = str.charAt(0);
		String remainingString = str.substring(1);
		HashSet<String> words = getAllPermutations(remainingString);
		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				String prefix = word.substring(0, i);
				String suffix = word.substring(i);
				permutations.add(prefix + first + suffix);
			}
		}
		return permutations;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getAllPermutations("ABC"));
		SwapWithoutTemp.swap(10, 20);
		CountGivenSubString.count("ABCDABCFABCEABCL", "ABC");
		LinkedList ll = new LinkedList();
		ll.practiceLLTrigger();
		BinaryTree1 bt = new BinaryTree1();
		bt.practiceBinaryTreeTrigger();
	}

}
