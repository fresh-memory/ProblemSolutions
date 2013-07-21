/*
*
*   Top down
* java pass by value.
* Primitive type value changed in submethod cannot be returned to caller...
*
*
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
    
    int max=0;
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
     max= 0;
     maxDepthHelper(root, 1);
     return max;
    }
    
    public void maxDepthHelper(TreeNode root, int depth){
        if(root==null) return;
        if(depth>max) max=depth;
        
        
         maxDepthHelper(root.left,depth+1);
         maxDepthHelper(root.right,depth+1);
        
    }
    
}
