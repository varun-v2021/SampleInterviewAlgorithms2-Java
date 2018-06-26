
public class CountGivenSubString {
	// str = ABCDABCFABCE
	// subStr = ABC
	// output = 3
	public static void count(String str, String subStr) {
		int subStrLen = subStr.length();
		int count = 0;
		for (int i = 0; i < str.length() - subStrLen; i++) {
			if(str.substring(i, i+subStrLen).equals(subStr))
				++count;
		}
		System.out.println(count);
	}
}
