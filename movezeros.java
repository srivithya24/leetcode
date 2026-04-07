class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;

        // 1. If the current element is non-zero, bring it forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }

        // 2. Fill the remaining positions with zeros
        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
