import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
        // Convert integers to Strings
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // Sort using custom comparator
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // Handle the case where the largest number is 0
        if (strs[0].equals("0")) {
            return "0";
        }

        // Build the final string
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println("Largest Number: " + sol.largestNumber(nums));
        // Expected Output: 9534330
    }
}