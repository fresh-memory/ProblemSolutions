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
        TreeNode prev = null;
        TreeNode prCur = null;
        TreeNode first = null;

    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        prev=null;
        prCur=null;
        first=null;
        if(root==null) return;
        
        
        recoverTreeH(root);    
            
            int temp = prCur.val;
            prCur.val = first.val;
            first.val = temp;
        
        
      
    }
    
    
    public void recoverTreeH(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //if(first!=null && two !=null) return;
        
        if(root==null) return;
        recoverTreeH(root.left);
        
        if(prev!=null && root.val<prev.val){              
                 first = root;  
                 if(prCur==null){
                    prCur=prev;
                 }

        }        
        prev=root;
        recoverTreeH(root.right);
    }
}
