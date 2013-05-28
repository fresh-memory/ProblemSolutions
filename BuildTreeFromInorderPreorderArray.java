/**
*
* Same as inorder and post order construction
*
/

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
     if(preorder.length==0 || inorder.length==0) return null;
     return buildHelper(preorder, inorder, 0,preorder.length-1, 0, inorder.length-1);
    
    }
    
    
    public TreeNode buildHelper(int[] preorder, int[] inorder, int left, int right, int ple, int pri ){
                if(left==right) return new TreeNode(inorder[left]);
                if(left>right) return null;
                
         TreeNode root = new TreeNode(preorder[ple]);
         for(int i=left; i<=right;i++){
             if(inorder[i]==preorder[ple]){
                 TreeNode leftNode = buildHelper(preorder, inorder,left,i-1, ple+1,ple+i-left);
                 TreeNode rightNode = buildHelper(preorder, inorder, i+1, right, ple+i-left+1, pri);
                 root.left=leftNode;
                 root.right=rightNode;
         
             }
         }
    return root;
    
    }
    
}
