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
    public boolean isBalanced(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root == null) return true;
        return getHeight(root) != -1;
    }
    
    public int getHeight(TreeNode root) {
          if(root.left == null && root.right == null) {
            return  1;
          }
          
          int left = 0;
          if(root.left != null) {
              left = getHeight(root.left);
              if(left == -1) {
                  return -1;
              }
          }
          int right = 0;
          if(root.right != null) {
            right = getHeight(root.right);
            if(right == -1) {
                return -1;
            }
          }
          
         if(Math.abs(left - right) >1) {
             return -1;
         }
         else {
             return Math.max(left, right) + 1;
         }
    }
}
