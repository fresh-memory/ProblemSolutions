/** Two Stack
* alternate read directions 
* Odd / even # of levels slightly different
*/
/*
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> stk1 = new Stack<TreeNode>();
        Stack<TreeNode> stk2 = new Stack<TreeNode>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr=null, arr2=null;
        if(root==null) return res;
        stk1.push(root);
        while(!stk1.isEmpty() || !stk2.isEmpty()){
             arr = new ArrayList<Integer>();
             while(!stk1.isEmpty()){
                  TreeNode temp = stk1.peek();
                  stk1.pop();
                 if(temp.left!=null){
                     stk2.push(temp.left);
                 }
                 if(temp.right!=null){
                     stk2.push(temp.right);
                 }
                
                 arr.add(temp.val);
             }
             res.add(arr);
             arr2 = new ArrayList<Integer>();
            while(!stk2.isEmpty()){
                    TreeNode temp = stk2.peek();
                  stk2.pop();
                 if(temp.right!=null){
                     stk1.push(temp.right);
                 }
                 if(temp.left!=null){
                     stk1.push(temp.left);
                 }
                
                 arr2.add(temp.val);
                
            
            } 
            // if odd level, arr2 will be empty, need to avoid empty
            if(arr2.size()!=0)
              res.add(arr2);
             
         
         }
        return res;
        
    }
}
