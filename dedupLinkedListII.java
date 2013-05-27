/*
*
*  Use a dummy node to ease the coding.
* Otherwise, it will be difficult to figure out the new head.
* Initalize dummy head as Integer.MAX_VALUE to avoid collision.
*curNode must start from head otherwise may lose head
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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(head==null || head.next==null) return head;
        ListNode newHead= new ListNode(Integer.MAX_VALUE);
        newHead.next=head;
        ListNode beginNode= newHead;
        //curNode must start from head otherwise may lose head's value
        ListNode curNode=head;
        ListNode pre = newHead;
        while(curNode.next!=null){
            if(curNode.val!=pre.val && curNode.val!=curNode.next.val){
                beginNode.next=curNode;
                beginNode=beginNode.next;
            }
            pre=pre.next;
            curNode=curNode.next;
        
    }
    if(pre.val!=curNode.val)
        beginNode.next=curNode;
    else
    beginNode.next=null;
    
    return newHead.next;
}

}



