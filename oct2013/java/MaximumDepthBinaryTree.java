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
    public int maxDepth(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null) return 0;
        int[] max = {Integer.MIN_VALUE};
        maxDepth(root, 0, max);
        return max[0];
    }
    
    public void maxDepth(TreeNode root, int predepth, int[] max) {
        if(root.left == null && root.right == null) {
            max[0] = Math.max(max[0], predepth + 1);
            return;
        }
        if(root.left != null) {
            maxDepth(root.left, predepth + 1, max);
        }
        if(root.right != null) {
            maxDepth(root.right, predepth + 1, max);
        }
        
    }
}
