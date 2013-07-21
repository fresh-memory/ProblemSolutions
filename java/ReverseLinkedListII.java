/*
*
*  when need to use a prevNode, need to have a dummy node before the head. It will make code much more concise.
*  For this problem, need to make sure count are right, initalization of the middleNode, farNode are correct.
*
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode fhead = new ListNode(0);
        
        fhead.next= head;
        int count=1; ListNode curNode = head, prevNode=fhead;
    while(count<m){
        prevNode=prevNode.next;
        curNode=curNode.next;
        count++;
    }
    // farNode initial value!!!
    ListNode middleNode=curNode.next, farNode=middleNode;
    while(middleNode!=null && count<n){
         //!!!
       middleNode=farNode;
       farNode=middleNode.next;
       middleNode.next=curNode;
       curNode=middleNode;
       count++;
    }
    
    
    prevNode.next.next=farNode;
    prevNode.next=curNode;
    
    return fhead.next;
    }
    
    
    
}
