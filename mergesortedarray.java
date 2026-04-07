class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for the end of valid elements in nums1 and nums2
        int i = m - 1;
        int j = n - 1;
        // Pointer for the last position in the combined nums1 array
        int k = m + n - 1;

        // Compare elements from the back and move the larger one to the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If there are remaining elements in nums2, copy them
        // (Note: If nums1 has remaining elements, they are already in place)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
