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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    
     int size = num.length;
     return sortedArrayToBST(num, 0, size-1);
     
        
    }
    
    public TreeNode sortedArrayToBST(int[] num,int left, int right) {
       if(left <=right){
       int middle = (left+right)/2;
        TreeNode root = new TreeNode(num[middle]);
        TreeNode leftNode = sortedArrayToBST(num, left, middle-1);
        TreeNode rightNode = sortedArrayToBST(num, middle+1, right);
        root.left = leftNode;
        root.right = rightNode;
        
        return root;
       }
       return null;
    
    
    
    }
    
}
