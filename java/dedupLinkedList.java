/**
* A bit different than array as linkedlist can be reconstructed
* Need to go through simple case
* duplicated / non duplicated to cover all edge cases
* 
/

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
        if(head==null) return null;
        ListNode preNode=head, beginNode=head;
        ListNode curNode=head.next;
        while(curNode!=null){
            while(curNode!=null && curNode.val==beginNode.val){
                curNode=curNode.next;
                preNode=preNode.next;
            }
            if(curNode!=null){
                 // special case when prevNode value is not a duplicated value
		 if(preNode!=beginNode){
                   preNode.next=null;
                }
                //preNode new value?
                preNode=beginNode;
                beginNode.next=curNode;
                beginNode=curNode;
            }
            
        } 
        // curNode reach the end
        beginNode.next=null;
        return head;
    }
}
