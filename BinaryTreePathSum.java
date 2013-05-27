/**
 Recursive
 Similar to BinaryTreeRootToLeaveSum

*/

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
    public boolean hasPathSum(TreeNode root, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
         if(root==null) return false;   
         return dfsHelper(root, target, 0);
        
    }
    
    public boolean dfsHelper(TreeNode root, int target, int sum){
             sum=sum+root.val;
        if(root.left==null && root.right==null){
             if(sum==target) return true;
             return false;
        }
        if(root.left!=null && root.right!=null)
              return dfsHelper(root.left, target, sum) || dfsHelper(root.right, target, sum);
        if(root.left==null && root.right!=null)
        return dfsHelper(root.right, target, sum);
        if(root.left!=null && root.right==null){
            return dfsHelper(root.left, target, sum);
        }
        return false;
    }
    
}
