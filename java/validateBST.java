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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return true;
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        
    }
    
    public boolean isValidBSTHelper(TreeNode root, int min, int max){
        if(root == null) return true;
        if(root.val>=max || root.val<=min) return false;
        else
            return isValidBSTHelper(root.left, min,root.val) &&
            isValidBSTHelper(root.right, root.val, max);    
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
public class Solution2 {
        // DO NOT write main() function
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int pre=Integer.MIN_VALUE;
        return isValidBSTHelper(root, pre);
        
    }
    
    public boolean isValidBSTHelper(TreeNode root, int prev){
        
        if(root==null) return true;
        if(isValidBSTHelper(root.left, prev)){
            
             if(root.val>prev) {
                prev=root.val;
                return isValidBSTHelper(root.right, prev);
            }
            else return false;
            
           
        }
        else return false; 
        
    }
    
}
