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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if(p==null && q==null) return true;
        // check null must be before checking (p.val!=q.val)
       if((p==null && q!=null) ||( q==null &&p!=null)||(p.val!=q.val)) return false;
        
        return isSameTree(p.right,q.right)&&isSameTree(p.left,q.left);
        
        
    }
}
