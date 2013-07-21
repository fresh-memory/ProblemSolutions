/*
* Tree element cannot negative!!!!!!!!!!!!!!!!
*  need to renew data structure that were passed from caller and keep updating.....
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
   // ArrayList<ArrayList<Integer>> res=null;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null) return res;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        //arr.add(root.val);
        pathHelper(root, sum, 0, arr, res);
        return res;
        
    }
    
    
    public void pathHelper(TreeNode root, int sum, int curSum, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> res){
            curSum= curSum+root.val;
            //if not create a new, all arr unpdating one ArrayList
            ArrayList<Integer> arr2 = new ArrayList<Integer>(arr);
            arr2.add(root.val);
         if(root.left==null && root.right==null){
               if(curSum==sum){
                  res.add(arr2);
               }
               else return;
           }
          else if(root.left!=null && root.right!=null){
                   
                    pathHelper(root.left,sum, curSum,arr2,res);
                    pathHelper(root.right,sum,curSum,arr2,res);
               
           }
           else if(root.left==null){
                pathHelper(root.right,sum, curSum, arr2,res);
              
            }
            
          else  if(root.right==null){
                 pathHelper(root.left,sum, curSum, arr2,res);
               
            }
        
    }
}
