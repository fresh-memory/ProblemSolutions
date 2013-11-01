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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> nodeArr = new ArrayList<Integer>();
        if(root == null) return nodeArr;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        
        while(!stack.isEmpty()) {
            
            while(root.left != null){
                root = root.left;
                stack.add(root);
            }
            TreeNode element = stack.pop();
            nodeArr.add(element.val);
            if(element.right != null){
                root = element.right;
                stack.push(root);
            }
        }
        return nodeArr;
    }
}
