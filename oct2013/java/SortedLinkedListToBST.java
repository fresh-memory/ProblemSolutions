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
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
       int length = 0;
       ListNode cur = head;
       while(cur!=null) {
           length++;
           cur = cur.next;
       }
       return sortedListToBST(head, 0, length - 1);
    }
    
    public TreeNode sortedListToBST(ListNode head, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = start+(end-start)/2;
        TreeNode leftChild = sortedListToBST(head, start, mid - 1);
        TreeNode root  = new TreeNode(head.val);
        // head = head.next;
         root.left = leftChild;
        // Java pass in Object by reference, so we can't change head but we can change its content :)
    
       if (head.next != null) { // "move to next"
          head.val = head.next.val;
          head.next = head.next.next;
        }
       
        root.right = sortedListToBST(head, mid + 1, end);
        return root;
    }
}
