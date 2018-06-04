package com.sample2.programs;

/*Length of the largest subarray with contiguous elements*/

public class LargestSubArray {

	public int min(int a, int b) {
		return a < b ? a : b;
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public int largestSubArrayLength(int[] arr, int len) {
		int max_len = 1;
		for (int i = 0; i < len - 1; i++) {
			int mx = arr[i], mn = arr[i];
			for (int j = i + 1; j < len; j++) {
				mx = max(mx, arr[j]);
				mn = min(mn, arr[j]);
				if (mx - mn == j - i) {
					max_len = max(max_len, mx - mn + 1);
				}
			}
		}
		return max_len;
	}

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 56, 58, 57, 90, 92, 93, 91, 94, 100 };
		int len = arr.length;
		LargestSubArray lenObj = new LargestSubArray();
		System.out.println("Max length of subarray with continuos ele: " + lenObj.largestSubArrayLength(arr, len));
	}

}
