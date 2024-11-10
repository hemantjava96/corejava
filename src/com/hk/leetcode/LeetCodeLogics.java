package com.hk.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCodeLogics {


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1LastIndex = m - 1;
        int nums2LastIndex = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (nums1LastIndex < 0) nums1[i] = nums2[nums2LastIndex--];
            else if (nums2LastIndex < 0) nums1[i] = nums1[nums1LastIndex--];
            else if (nums1[nums1LastIndex] > nums2[nums2LastIndex]) nums1[i] = nums1[nums1LastIndex--];
            else nums1[i] = nums2[nums2LastIndex--];
        }
    }

    public void moveZeroes(int[] nums) {
        int currentIndex = 0;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[currentIndex] = nums[i];
                currentIndex++;
            } else zeroCount++;
        }
        while (zeroCount > 0) {
            nums[nums.length - zeroCount] = 0;
            zeroCount--;
        }
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> result = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(i -> i, HashMap::new, Collectors.summingInt(i -> 1)));
        return result.keySet().stream().sorted((i, j) -> result.get(j) - result.get(i)).limit(k).mapToInt(Integer::intValue).toArray();
    }

    public int[] topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(i -> i, Collectors.summingInt(i -> 1))).entrySet().parallelStream().sorted((e1, e2) -> e2.getValue() - e1.getValue()).limit(k).mapToInt(Map.Entry::getKey).toArray();
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x < 10) {
            return true;
        }

        String number = Integer.toString(x);
        int left = 0;
        int right = number.length() - 1;
        while (left < right) if (number.charAt(left++) != number.charAt(right--)) return false;
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

            if (minAsOfNow > prices[i]) minAsOfNow = prices[i];
            if (maxProfit < (prices[i] - minAsOfNow)) maxProfit = prices[i] - minAsOfNow;

        }
        return maxProfit;
    }

    // The ASCII value of '0' is 48.
    // The ASCII value of '9' is 57.
    // The ASCII value of '-' is 45.
    // The ASCII value of '+' is 43.
    // The ASCII value of ' ' is 32.
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        long ans = 0;
        boolean isNegative = false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '-') {
                    isNegative = true;
                    continue;
                } else if (s.charAt(i) == '+') {
                    isNegative = false;
                    continue;
                }
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                ans = (ans * 10) + (s.charAt(i) - '0');
                if (isNegative) {
                    if (-ans < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (ans > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            } else break;
        }

        if (isNegative) return -1 * (int) ans;
        else return (int) ans;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        boolean stop = false;
        for (int i = 0; i < strs[0].length(); i++) {
            char current = strs[0].charAt(i);
            ;
            for (String str : strs) {
                if (str.length() < i + 1) {
                    return prefix;
                }
                if (str.charAt(i) != current)
                    stop = true;
            }
            if (!stop) {
                prefix = prefix + current;
            }
        }
        return prefix;
    }

    public void rotate(int[] nums, int k) {
        //https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/646/
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1); // reverse
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
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

            if (flag) ind++;
            else ind--;

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
            whileLoop:
            while (true) {
                if ((i - j) >= 0 && (i + j) < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
                    j++;
                } else {
                    j--;
                    if (maxLength < ((2 * j) + 1)) {
                        maxLength = (2 * j) + 1;
                        start = i - j;
                        end = i + j;
                    }
                    break;
                }
            }
            // for even
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                int k = i + 1;
                j = 0;
                whileLoop2:
                while (true) {
                    if ((i - j) >= 0 && (k + j) < s.length() && s.charAt(i - j) == s.charAt(k + j)) {
                        j++;
                    } else {
                        j--;
                        if (maxLength < ((2 * j) + 2)) {
                            maxLength = (2 * j) + 2;
                            start = i - j;
                            end = k + j;
                        }
                        break;
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

        if (length % 2 == 0) return Double.valueOf((num[length / 2] + num[(length / 2) - 1])) / 2;
        else return num[(length / 2)];
    }

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> charSet = new HashSet<>();
        int maxlength = 0;

        for (int i = 0; i < s.length(); i++) {
            LoopB:
            for (int j = i; j < s.length(); j++) {
                if (charSet.contains(s.charAt(j))) {
                    if (maxlength < charSet.size()) maxlength = charSet.size();
                    charSet.clear();
                    break;
                } else {
                    charSet.add(s.charAt(j));
                    if (maxlength < charSet.size()) maxlength = charSet.size();
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
                return new int[]{i, map.get(value)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -1 * nums[i];
            List<int[]> couples = findCouples(target, nums, i);
            for (int[] couple : couples) {
                result.add(Arrays.asList(nums[i], couple[0], couple[1]));
            }
        }
        return new ArrayList<>(result);
    }

    private List<int[]> findCouples(int target, int[] nums, int index) {
        List<int[]> op = new ArrayList<>();
        int left = index + 1;
        int right = nums.length - 1;
        while (left < right) {
            if (target == nums[left] + nums[right]) {
                op.add(new int[]{nums[left], nums[right]});
                left++;
                right--;
            } else if (target < nums[left] + nums[right]) {
                right--;
            } else {
                left++;
            }
        }
        return op;
    }

    public int removeDuplicates(int[] nums) {
        //https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/
        int curr = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++curr] = nums[i];
            }
        }
        return ++curr;
    }

    public int maxProfit1(int[] prices) {
        //https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/564/
        //Best Time to Buy and Sell Stock II
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit = maxProfit + (prices[i] - prices[i - 1]);
            }
        }

        return maxProfit;
    }

    public boolean isMatch(String string, String pattern) {
        return true;

    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char num = board[i][j];
                if (num != '.') {
                    if (seen.add(num + " at row " + i) && seen.add(num + " at col " + j) && seen.add(num + " at box " + j / 3 + "-" + i / 3))
                        continue;
                    else return false;
                }
            }
        }
        return true;
    }

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //transpose of matrix (i,j = j,1)
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int val = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = val;
            }
        }
        //reverse the rows
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int val = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = val;
            }
        }
    }

    public int reverseInt(int x) {
        int reverse = 0;
        while (x != 0) {
            int remainder = x % 10;
            if (reverse > Integer.MAX_VALUE / 10 || reverse < Integer.MAX_VALUE) return 0;
            reverse = reverse * 10 + remainder;
            x = x / 10;
        }
        return reverse;
    }

    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        System.out.println(Arrays.toString(freq));
        return -1;
    }

    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) return false;
        int[] freq = new int[26];
        for (int i = 0; i < sLength; i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < tLength; i++)
            freq[s.charAt(i) - 'a']--;
        for (int i : freq)
            if (i != 0) return false;
        return true;
    }

    public boolean isPalindrome(String s) {

        // replace the given string with empty string except the pattern "[^a-zA-Z0-9]"
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return s.contentEquals(new StringBuffer(s).reverse());
    }

    public int coinChange(int[] coins, int amount) {
        // dp[i] := the minimum number of coins to make up i
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, amount + 1);

        for (final int coin : coins)
            for (int i = coin; i <= amount; ++i)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    public void deleteNode(ListNode node) {
       ListNode prev = null;
        while (node != null && node.next != null){
            prev = node;
            node.val = node.next.val;
            node = node.next;
        }
        prev.next=null;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        while (fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        slowNode.next = slowNode.next.next;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev=null;
        while (curr != null ){
           ListNode temp = curr.next;
           curr.next=prev;
           prev =curr;
           curr = temp;
        }
        return prev;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        if(list1==null)
            return list2;
        else if (list2==null)
            return list1;

        ListNode head = null;
        ListNode itr = null;

        if(curr1.val <= curr2.val){
            head=curr1;
            itr=curr1;
            curr1 = curr1.next;
        }else {
            head=curr2;
            itr=curr2;
            curr2=curr2.next;
        }

        while (curr1 != null || curr2 != null){

            if(curr1 == null && curr2!=null){
                itr.next=curr2;
                curr2=curr2.next;
            } else if (curr2 == null && curr1!=null) {
                itr.next=curr1;
                curr1=curr1.next;
            }
            if(curr1.val <= curr2.val){
               itr.next=curr1;
               curr1=curr1.next;
            }else {
                itr.next=curr2;
                curr2=curr2.next;
            }
            itr=itr.next;
        }
        return head;
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
