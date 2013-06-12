/*
*
*  iterative in the level
*  Recursive on the next level first available node
*
*
*/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    if(root==null) return;
    root.next=null;
    conHelp(root);
}   
    public void conHelp(TreeLinkNode root1){
        TreeLinkNode root = root1;
        TreeLinkNode prevNode = null;
        TreeLinkNode firstNode = null;
       
        while(root!=null){
            if(root.left!=null){
                if(firstNode==null) firstNode = root.left;
             if(prevNode==null) prevNode=root.left;  
             else {prevNode.next=root.left;
                prevNode=prevNode.next;  
            
             }
            }
           // else{
                
                 if(root.right!=null){
                     if(firstNode==null) firstNode = root.right;
                     if(prevNode==null) prevNode=root.right;  
                      else {prevNode.next=root.right;
                    
                    prevNode=prevNode.next;    
                 }
                 }
                 // left right both null do nothing; 
            //} 
        root=root.next;
      }
      if(prevNode ==null) return;
       prevNode.next=null;
       if(firstNode == null) return ;
      conHelp(firstNode);
    }
}
