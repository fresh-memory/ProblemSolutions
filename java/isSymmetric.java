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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        
        if(root==null) return true;
        return isSame(root.left,root.right);
        
    }
    
  boolean  isSame(TreeNode a, TreeNode b){
        if(a==null && b==null) return true;
        if(a==null&&b!=null || a!=null&&b==null) return false;
        if(a.val==b.val){
            return isSame(a.left,b.right) && isSame(a.right,b.left);     
        }
        else return false;
    
    }
    
}
