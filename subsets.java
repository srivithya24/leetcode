import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Add the current subset to the result list
        result.add(new ArrayList<>(tempList));
        
        for (int i = start; i < nums.length; i++) {
            // Include the element
            tempList.add(nums[i]);
            
            // Recurse to the next element
            backtrack(result, tempList, nums, i + 1);
            
            // Backtrack: Remove the last element to explore other branches
            tempList.remove(tempList.size() - 1);
        }
    }
}
