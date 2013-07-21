/**
*
* Recursive bottom up
* Possible negative values in tree
* Result obj: x bented max (paramid max)  y straight max
* OK to  remove either global max or x 
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
    
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
       
        
        max=Integer.MIN_VALUE;
        
        Result r = maxHelper(root);
        if(max<r.x) max=r.x;
        if(max<r.y) max=r.y;
        return max;
       
    }
    
    public Result maxHelper(TreeNode root){
        if(root==null) return new Result(Integer.MIN_VALUE, Integer.MIN_VALUE);
        
        
       // Result r1= maxHelper(root.left);
       //    Result r2= maxHelper(root.right);
       if(root.left==null && root.right==null){
            if(max<root.val)
            max = root.val;    
            return new Result(root.val, root.val);
        }
        else if(root.left==null){
            
            Result r = maxHelper(root.right);
            int val_x = Math.max(root.val, root.val+r.y);
            //val_x=Math.max(val_x, root.val+root.right.val);
            if(max<val_x) max =val_x;
            return new Result(val_x,val_x);
        }
        
        else if(root.right==null){
            Result r = maxHelper(root.left);
            int val_x = Math.max(root.val, root.val+r.y);
            
            if(max<val_x) max= val_x;
            return new Result(val_x,val_x);
        }
  
       else{
         Result r1= maxHelper(root.left);
         Result r2= maxHelper(root.right);
        if(max<r1.x) max=r1.x;
        if(max<r2.x) max=r2.x;
        if(max<root.val) max= root.val;
        int val_x=r1.y+r2.y+root.val;
        int left =r1.y+root.val;
        int right =r2.y+root.val;
        if(left>val_x) val_x=left;
        if(right>val_x) val_x=right;
        if(val_x<root.val) val_x=root.val;
        
        if(max<val_x) max=val_x;
        int val_y= r1.y>r2.y?r1.y+root.val:r2.y+root.val;
        
        if(val_y<root.val) val_y=root.val;
        if(max<val_y) max=val_y;
        return new Result(val_x,val_y);
       }
    }
    
    
    class Result{
        int x;
        int y;
        int max;
        Result(int _x, int _y){
            
            this.x=_x;
            this.y=_y;
           
        }
    }
}
