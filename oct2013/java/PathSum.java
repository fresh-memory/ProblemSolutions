/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null) return false;
        return hasPathSum(root, 0, sum);
        
    }
    
    public boolean hasPathSum(TreeNode root, int presum, int sum) {
        if(root.left == null && root.right == null) {
            return presum + root.val == sum;
        }
        
        boolean left =false, right = false;
        if(root.left != null) {
            left = hasPathSum(root.left, presum + root.val, sum);
        }
        if(root.right != null) {
            right = hasPathSum(root.right, presum + root.val, sum);
        }
        return left || right;
    }
}
