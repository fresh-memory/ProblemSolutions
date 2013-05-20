/** no special character used 
* used two counters to keep number of elements in each level (curCount, nextCount)
*  Draw a few examples to derive the solution
* Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null) return res;
        int curCount=0, nextCount=0;
        q.add(root);
        curCount=1;
        ArrayList<Integer> arr=null;
        //start of new level
        boolean levelFlag=true;
        while(!q.isEmpty()){
            if(levelFlag==true){
                arr = new ArrayList<Integer>(); 
                levelFlag=false;
            }
            TreeNode curNode = q.poll();
            arr.add(curNode.val);
            if(curNode.left!=null) {
                q.add(curNode.left);
                nextCount++;
            }
            if(curNode.right!=null) {
                q.add(curNode.right);
                nextCount++;
            }
            
            curCount--;
            if(curCount==0){
                curCount=nextCount;
                nextCount=0;
                levelFlag=true;
                res.add(arr);
            }
            
            
        }
        return res;
        
    }
}
