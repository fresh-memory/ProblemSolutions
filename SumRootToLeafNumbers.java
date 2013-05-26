/*
*
* Recursive dfs
* Pay attention to different conditions. 
* Binary Tree conditoin, both leaves null, one null, both leaves not null 
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
    
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return 0;
       return sumNumbersHelper(root,0);
       
       
    }
    public int sumNumbersHelper(TreeNode node, int sum){
         sum=sum*10+node.val;
        if(node.left==null && node.right==null) return sum;
        
         if(node.left!=null && node.right!=null){
          return   sumNumbersHelper(node.left, sum)+sumNumbersHelper(node.right, sum);
         }
         if(node.left==null && node.right!=null){
         return sumNumbersHelper(node.right, sum);
         
         }
         
         if(node.right==null && node.left!=null){
           return sumNumbersHelper(node.left,sum);   
         }
     
     return sum;
    }
    
    
}
