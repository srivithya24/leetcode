class Solution:
    def permute(self, nums):
        results = []
        
        def backtrack(current_path):
            # Base Case: If the path length matches the input, we found a permutation
            if len(current_path) == len(nums):
                results.append(list(current_path))
                return
            
            for num in nums:
                # If the number is already used, skip it
                if num in current_path:
                    continue
                
                # Add the number and move to the next level
                current_path.append(num)
                backtrack(current_path)
                
                # Backtrack: remove the number to try a different path
                current_path.pop()
        
        backtrack([])
        return results
