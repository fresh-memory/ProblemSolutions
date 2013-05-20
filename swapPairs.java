/***
* Recursive
* Looks easy but need to avoid pitfall of which node the current point to.
* Case: head==null, head.next==null, odd number of nodes and even number of nodes.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
     if(head==null) return null;
     ListNode wNode=head, p=head.next;
     if(p==null){
         return head;
     }
    
    ListNode newHead = swapPairs(head.next.next);
    wNode.next=newHead;
    p.next=wNode;
    return p;    
        
    }
}
