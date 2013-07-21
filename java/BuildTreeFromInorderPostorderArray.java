/**
*
* Be very careful about the left right pointer name of each array 
* e.g., never call postorder[right] it should be postorder[pri]!!!!!!
* Otherwise will cause bug and waste time to debug...... 
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder.length==0 || postorder.length==0) return null;
        return buildHelper(inorder,postorder,0,inorder.length-1, 0,postorder.length-1);
        
    }
    
    
    public TreeNode buildHelper(int[] inorder, int[] postorder, int left, int right, int ple, int pri){
        
           if(left==right) return new TreeNode(inorder[left]);
            //cannot miss
           if(left>right) return null;
          TreeNode  newRoot = new TreeNode(postorder[pri]);
          for(int i=left; i<=right;i++){
              if(inorder[i]==postorder[pri]){
                  
                TreeNode  leftNode = buildHelper(inorder, postorder, left,i-1, ple,ple+i-1-left);
                TreeNode  rightNode = buildHelper(inorder,postorder, i+1,right, ple+i-left, pri-1);
                newRoot.left=leftNode;
                newRoot.right=rightNode;
              
              }
          }
          
          return newRoot;
    }
    
}
