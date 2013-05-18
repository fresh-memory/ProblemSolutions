/***
* Every TreeNode actually is double-linked list Node as well. It has two pointers.
* Recursive still. Return right tail. The base case is that right tail is null. Then make it as left tail.
* if left tail is null, lefttail is root.
* Since the return value is right tail, so for each subtree converted linkedlist, you have head and tail.
* Then it is easy to link the root with the rest two links
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
    
   public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return;   
        flattenHelper(root);
        
    }
    
  public  TreeNode flattenHelper(TreeNode root){
        if(root==null) return null;
        TreeNode leftTail = flattenHelper(root.left);
        if(leftTail==null){
            leftTail=root;
        }
        
        TreeNode rightTail = flattenHelper(root.right);
        if(rightTail==null){
            rightTail=leftTail;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        leftTail.right=temp;
        root.left=null;
       return rightTail;
} 
}
