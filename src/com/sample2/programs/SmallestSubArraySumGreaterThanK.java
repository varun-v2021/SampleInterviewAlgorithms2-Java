package com.sample2.programs;

public class SmallestSubArraySumGreaterThanK {

	public int getSmallestSubArratLength(int[] arr, int len, int k) {
		int start = 0, end = 0;
		int min_len = len + 1, curr_sum = 0;
		while (end < len) {
			while (curr_sum <= k && end < len)
				curr_sum += arr[end++];
			while (curr_sum > k && start < len) {
				if (end - start < min_len) {
					min_len = end - start;
				}
				curr_sum -= arr[start++];
			}
		}
		return min_len;
	}

	public static void main2(String[] args) {
		int[] arr = { 1, 4, 45, 6, 10, 19 };
		int len = arr.length;
		int K = 51;
		SmallestSubArraySumGreaterThanK obj = new SmallestSubArraySumGreaterThanK();
		int result = obj.getSmallestSubArratLength(arr, len, K);
		// if after adding all the elements in the
		// array, the sum wasn't greater than K
		if (result == len + 1)
			System.out.println("Not possible");
		else
			System.out.println("smallest length of sub array whose sum is greater than K: " + K + " is: " + result);
	}
}
