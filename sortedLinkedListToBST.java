/**
* recursive + construct new tree (not bending the original linkedlist to make it a tree that's may be too expensive)
* need to know the length of the list
*Pitfall: it can take long time to find the mid point each time.
*
* An alternative is to during counting, converting the linkedlist to arraylist which enable you to index nod
*so easier to find the mid-point;
**/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if(head==null) return null;
       ListNode temp=head;
        int counter=1;
        while(temp.next!=null){
            counter++;
            temp=temp.next;
        }
        
        return sortedListToBST(head, 0, counter-1);
    }      
        public TreeNode sortedListToBST(ListNode head, int start, int end){
            if(head==null || start>end) return null;
            int mid =start+(end-start)/2;
            int tempMid=mid;
            ListNode midhead=head;
            while(tempMid!=0){
                midhead=midhead.next;
                tempMid--;
            }
            
            TreeNode leftNode = sortedListToBST(head, start,mid-1);
            TreeNode root = new TreeNode(midhead.val);
            TreeNode rightNode = sortedListToBST(head, mid+1, end);
            root.left=leftNode;
            root.right =rightNode;
            return root;
        }
        
    
}
