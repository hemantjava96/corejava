package com.hk.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCodeLogics {
	public boolean isMatch(String s, String p) {
        return false;
    }

	public int[] topKFrequent1(int[] nums, int k) {
		Map<Integer, Integer> result = Arrays.stream(nums)
				.boxed()
				.collect(Collectors.groupingBy(i -> i, HashMap::new, Collectors.summingInt(i -> 1)));
		return result.keySet().stream().sorted((i, j) -> result.get(j) - result.get(i)).limit(k).mapToInt(Integer::intValue).toArray();
	}
	public int[] topKFrequent(int[] nums, int k) {
		return Arrays.stream(nums).boxed()
				.collect(Collectors.groupingBy(i -> i, Collectors.summingInt(i -> 1)))
				.entrySet().parallelStream()
				.sorted((e1, e2) -> e2.getValue() - e1.getValue())
				.limit(k)
				.mapToInt(Map.Entry::getKey)
				.toArray();
	}

	public boolean isPalindrome(int x) {
		if (x<0)
			return false;
		else if (x < 10) {
			return true;
		}

		String number = Integer.toString(x);
		int left = 0;
		int right = number.length()-1;
		while(left<right)
			if (number.charAt(left++) != number.charAt(right--)) return false;
		return true;
/*
        String string = Integer.toString(x);
        return string.equals((new StringBuilder(string).reverse().toString()));
*/
	}

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minAsOfNow = prices[0];
		for (int i = 0; i < prices.length; i++) {

			if (minAsOfNow > prices[i])
				minAsOfNow = prices[i];
			if (maxProfit < (prices[i] - minAsOfNow))
				maxProfit = prices[i] - minAsOfNow;

		}
		return maxProfit;
	}

	// The ASCII value of '0' is 48.
	// The ASCII value of '9' is 57.
	// The ASCII value of '-' is 45.
	// The ASCII value of '+' is 43.
	// The ASCII value of ' ' is 32.
	public int myAtoi(String s) {
		int si = 0, l = s.length(), flag = Integer.MAX_VALUE / 10;
		boolean neg = false, range = false, sign = false, dig = false;
		first: for (int i = 0; i < l; i++) {
			char ch = s.charAt(i);
			if ((sign == true) && (ch < 48 || ch > 57))
				break;// not a digit
			if ((ch < 48 || ch > 57) && (ch != 43 && ch != 45 && ch != 32))
				break; // not digit/-/+/space
			else if (ch >= 48 && ch <= 57) {
				dig = true;// its a digit

				// check range
				if ((si > flag) || (si == flag && ch > '7')) {
					range = true;
					break;
				}
				int a = ch - '0';

				si = si * 10 + a;
			} else {
				// its either -,+,space
				switch (ch) {
				case '-':
					if (dig)
						break first;
					else if (!sign) {
						sign = true;
						neg = true;
					} else
						return 0;
					break;
				case '+':
					if (dig)
						break first;
					else if (!sign)
						sign = true;
					else
						return 0;
					break;
				case ' ':
					if (dig)
						break first;
					break;
				default:
					break first;
				}
			}
		}
		if (neg == false && range == false)
			return si;
		else if (neg == false && range == true)
			return Integer.MAX_VALUE;
		else if (neg == true && range == false)
			return si * (-1);
		else
			return Integer.MIN_VALUE;
	}

	public void rotate(int[] nums, int k) {

		k = k % nums.length;
		reverse(nums, 0, nums.length - 1); // reverse
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);

		System.out.println(Arrays.toString(nums));

		// for (int i = 1; i <= k; i++) {
		// rightRotate(nums);
		// }

	}

	private void reverse(int[] nums, int si, int ei) {
		while (si < ei) {
			int temp = nums[si];
			nums[si] = nums[ei];
			nums[ei] = temp;
			si++;
			ei--;
		}
	}

	private void rightRotate(int[] nums) {
		int temp = nums[0];
		for (int j = 0; j < nums.length; j++) {
			if (j == nums.length - 1) {
				nums[0] = temp;
			} else {
				int c = nums[j + 1];
				nums[j + 1] = temp;
				temp = c;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	public int reverse(int x) {
		StringBuffer sb = new StringBuffer(Integer.valueOf(x).toString());
		sb = sb.reverse();
		try {
			return Integer.valueOf(sb.toString());
		} catch (NumberFormatException e) {
			try {
				return -1 * Integer.valueOf(sb.toString().replace("-", ""));
			} catch (NumberFormatException e1) {
				return 0;
			}
		}
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int nums1LastIndex = m - 1;
		int nums2LastIndex = n - 1;
		for (int i = nums1.length - 1; i >= 0; i--) {
			if (nums1LastIndex < 0)
				nums1[i] = nums2[nums2LastIndex--];
			else if (nums2LastIndex < 0)
				nums1[i] = nums1[nums1LastIndex--];
			else if (nums1[nums1LastIndex] > nums2[nums2LastIndex])
				nums1[i] = nums1[nums1LastIndex--];
			else
				nums1[i] = nums2[nums2LastIndex--];
		}
	}

	public String convert(String s, int numRows) {

		if (numRows == 1) {
			return s;
		}

		StringBuffer[] str = new StringBuffer[numRows];
		for (int i = 0; i < str.length; i++) {
			str[i] = new StringBuffer();
		}

		boolean flag = true;
		int i = 0;
		int ind = 0;
		while (true) {
			str[ind].append(s.charAt(i));
			i++;
			if (i >= s.length()) {
				break;
			}

			if (ind == 0) {
				flag = true;
			} else if (ind == numRows - 1) {
				flag = false;
			}

			if (flag)
				ind++;
			else
				ind--;

		}

		StringBuffer op = new StringBuffer();
		for (int j = 0; j < str.length; j++) {
			op.append(str[j]);
		}

		return op.toString();
	}

	public String longestPalindrome(String s) {

		int maxLength = 0;
		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {
			// for odd
			int j = 0;
			whileLoop: while (true) {
				if ((i - j) >= 0 && (i + j) < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
					j++;
				} else {
					j--;
					if (maxLength < ((2 * j) + 1)) {
						maxLength = (2 * j) + 1;
						start = i - j;
						end = i + j;
					}
					break whileLoop;
				}
			}
			// for even
			if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
				int k = i + 1;
				j = 0;
				whileLoop2: while (true) {
					if ((i - j) >= 0 && (k + j) < s.length() && s.charAt(i - j) == s.charAt(k + j)) {
						j++;
					} else {
						j--;
						if (maxLength < ((2 * j) + 2)) {
							maxLength = (2 * j) + 2;
							start = i - j;
							end = k + j;
						}
						break whileLoop2;
					}
				}
			}

		}

		return s.substring(start, end + 1);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// Combine elements of num1 and num2 into a new array
		int nums1Index = 0;
		int nums2Index = 0;
		int length = nums1.length + nums2.length;
		int[] num = new int[length];
		for (int i = 0; i < length; i++) {

			if (nums1Index == nums1.length) {
				num[i] = nums2[nums2Index];
				nums2Index++;
			} else if (nums2Index == nums2.length) {
				num[i] = nums1[nums1Index];
				nums1Index++;
			} else if (nums1[nums1Index] > nums2[nums2Index]) {
				num[i] = nums2[nums2Index];
				nums2Index++;
			} else {
				num[i] = nums1[nums1Index];
				nums1Index++;
			}
		}

		if (length % 2 == 0)
			return Double.valueOf((num[length / 2] + num[(length / 2) - 1])) / 2;
		else
			return num[(length / 2)];
	}

	public int lengthOfLongestSubstring(String s) {

		HashSet<Character> charSet = new HashSet<>();
		int maxlength = 0;

		LoopA: for (int i = 0; i < s.length(); i++) {
			LoopB: for (int j = i; j < s.length(); j++) {
				if (charSet.contains(s.charAt(j))) {
					if (maxlength < charSet.size())
						maxlength = charSet.size();
					charSet.clear();
					break LoopB;
				} else {
					charSet.add(s.charAt(j));
					if (maxlength < charSet.size())
						maxlength = charSet.size();
				}
			}
		}

		return maxlength;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode op = new ListNode();
		ListNode head = op;
		while (l1 != null || l2 != null || carry != 0) {
			op.next = new ListNode();
			op = op.next;
			int val1 = (l1 == null) ? 0 : l1.val;
			int val2 = (l2 == null) ? 0 : l2.val;

			int sum = val1 + val2 + carry;
			int result = sum % 10;
			carry = sum / 10;

			l1 = (l1 == null) ? null : l1.next;
			l2 = (l2 == null) ? null : l2.next;
			op.val = result;
		}

		return head.next;
	}

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int value = target - nums[i];
			if (map.containsKey(value)) {
				return new int[] { i, map.get(value) };
			}
			map.put(nums[i], i);
		}
		return new int[] {};
	}
}

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
