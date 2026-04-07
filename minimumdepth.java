class Solution {
    public int minDepth(TreeNode root) {
        // 1. If the tree is empty, depth is 0
        if (root == null) {
            return 0;
        }
        
        // 2. If it's a leaf node, depth is 1
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        // 3. If the left subtree is null, recurse on the right subtree
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        
        // 4. If the right subtree is null, recurse on the left subtree
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        
        // 5. If both children exist, take the minimum of their depths
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
