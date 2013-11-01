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
    
     int max = Integer.MIN_VALUE;
      public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if(root == null) return max;
        getMaxSum(root);
        return max;
    }

    private int getMaxSum(TreeNode node) {
        
        //if(node == null) return 0;
        
        int leftSum =  0;
        if(node.left != null) {
            leftSum = getMaxSum(node.left);
        }
        int rightSum = 0;
        if(node.right != null) {
            rightSum = getMaxSum(node.right);
        }
        //Many conditions
       // getMaxSum returns the max sum root from node rather than other offspring node
        int a = Math.max(leftSum + node.val, rightSum + node.val);
        int b = Math.max(a, node.val);
        int c = Math.max(b,  leftSum + node.val + rightSum);
        //int d = Math.max(leftSum, rightSum);
        //int e = Math.max(d,c);
        max = Math.max(c, max);
        return b;
    }

}

