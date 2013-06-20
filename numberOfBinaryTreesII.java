/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

     return generateHelper(1,n);
    }
    
    public ArrayList<TreeNode> generateHelper(int startIndex, int endIndex){
        
        ArrayList<TreeNode>  rootList = new ArrayList<TreeNode>(); 
        if(startIndex>endIndex){
            rootList.add(null);
            return rootList;
        }
        if(startIndex==endIndex){
            rootList.add(new TreeNode(startIndex));
            return rootList;
        }
        
        for(int i=startIndex;i<=endIndex;i++){
           ArrayList<TreeNode> rightRootList =  generateHelper(i+1, endIndex);
           ArrayList<TreeNode> leftRootList = generateHelper(startIndex, i-1);   
           for(int left=0;left<leftRootList.size();left++){
               for(int right=0;right<rightRootList.size();right++){
                   TreeNode subRoot = new TreeNode(i);
                   subRoot.left=leftRootList.get(left);
                   subRoot.right=rightRootList.get(right);
                   rootList.add(subRoot);
               }
               if(rightRootList.size()==0){
                   TreeNode subRoot = new TreeNode(i);
                   subRoot.left=leftRootList.get(left);
                   subRoot.right=null;
                   rootList.add(subRoot);
               }
               
           }
           if(leftRootList.size()==0){
                 for(int right=0;right<rightRootList.size();right++){
                   TreeNode subRoot = new TreeNode(i);
                   subRoot.left=null;
                   subRoot.right=rightRootList.get(right);
                   rootList.add(subRoot);
               }
           
           }
         
        }
        
        return rootList;
        
    }
}
