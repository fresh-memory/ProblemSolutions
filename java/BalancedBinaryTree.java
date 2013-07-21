/**
*  Bottom up 
* Need to completely understand the definition of balanced tree
* It is possible that the two subtree are balanced but overall not balanced 
* also possible subtree not balanced but overall balanced for example, triangle shape
* yet also possible one of the subtree not balanced but overall balanced
* so need to left&&right&&current 
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
    
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
          if(root==null) return true;
          return getHeight(root)>=0;
    
    }
    
    public int getHeight(TreeNode root){
        
        if(root==null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(left<0|| right<0 ||Math.abs(left-right)>1) return -1;
        else return Math.max(left,right)+1;
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
public class Solution {
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return true;
       Result left = helper(root.left);
       Result right = helper(root.right);
       if(Math.abs(left.height-right.height)>1) return false;
       if(!left.balance ||!right.balance) return false;
       return true;
    
    }
    
    public Result helper(TreeNode root){
         
         if(root==null){ return new Result(0, true); }
         Result left =helper(root.left);
         Result right =helper(root.right);
         boolean  nb=true;
         if(Math.abs(left.height-right.height)>1)  nb=false;
         int newHeight= Math.max(left.height,right.height)+1;
         nb= nb&& left.balance && right.balance;
         
         return new Result(newHeight,nb);
    }
    
    
    class Result{
        int height;
        boolean balance;
        Result(int _height, boolean _balance){
            this.height=_height;
            this.balance=_balance;
        }
    }

}
