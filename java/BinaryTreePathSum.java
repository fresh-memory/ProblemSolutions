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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
          
          if(root==null) return false;
          return helper(root,sum,0);
    }
    
    public boolean helper(TreeNode root, int sum, int total){
        if(root.left==null && root.right==null){
              return sum==total+root.val;
          }
        if(root.left==null && root.right!=null){
             return helper(root.right,sum,total+root.val);
        } 
        if(root.right==null && root.left!=null){
            return helper(root.left,sum,total+root.val);
        }
        else 
     return helper(root.left,sum,total+root.val) || helper(root.right,sum,total+root.val);
        
    }
    
}













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
