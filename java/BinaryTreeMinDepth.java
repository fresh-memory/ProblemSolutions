/*
*
*  Bottom up
* Difference with Max Depth: if a tree's left child is null, the minDepth is right child's depth+1 rather than 1;
* Be careful about the definition of tree's depth...
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
  
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return minDepthHelper(root);
    }
    
    
    int minDepthHelper(TreeNode root){
        if(root==null) return 0;
        
       int left  =  minDepthHelper(root.left);
       int right =  minDepthHelper(root.right);
       if(left==0) return right+1;
       if(right==0) return left+1;
       
       return left<right?left+1:right+1;
        
    }
}
