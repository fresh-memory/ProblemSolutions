/** Need revisit and be familiar with this iterative algo.
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        if(root==null) return arr;
        stk.push(root);
        TreeNode cur=  root.left;
        while(!stk.isEmpty()){
           //if left not null add left 
            while(cur!=null){  
                stk.push(cur);
                cur=cur.left;
            }

           //if left ==null pop cur
             //{ also if right child is null, need to pop from the curren}t
            cur = stk.peek();
            stk.pop();
            arr.add(cur.val);
            
            // go to right branch if right not null add right
            cur=cur.right;
            if(cur!=null){
                stk.push(cur);
                //still need to go from left
                cur=cur.left;    
            }
            
        }
        
        
        return arr;
    }
}
