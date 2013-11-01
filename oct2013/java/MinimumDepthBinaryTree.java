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
    public int minDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // java pass by value so cannot pass  a min down
	// either use an array or use a global variable
	int[] min = {Integer.MAX_VALUE};
        if(root == null) return 0;
        minDepth(root, 0, min);
        return min[0];
        
    }
    
    public void minDepth(TreeNode root, int preDepth, int[] min) {
          if(root.left == null && root.right == null) {
              min[0] = Math.min(min[0], preDepth + 1);
              return;
          }
          if(root.left != null) {
            minDepth(root.left, preDepth + 1, min);
          }
          if(root.right != null) {
            minDepth(root.right, preDepth + 1, min);
          }
    }
}
