/**
*
* Be careful n could be bigger than the length of the list
*
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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(head==null || n==0) return head;
        // 0 ~ n-1 iterate n times 
        int count=0; ListNode curNode=head, frontNode=head;
        while(count<n){
            
            curNode= curNode.next;
           // n bigger than length of list need to start over
           if(curNode==null){curNode=head;}
            count++;
        }
        
        //if(curNode==null) return head;
        
        while(curNode.next!=null){
            
            curNode =curNode.next;
            frontNode=frontNode.next;
        }
        
        curNode.next=head;
        ListNode newHead = frontNode.next;
        if(newHead==null) return head;
        frontNode.next=null;
        
       // frontNode=null;
        return newHead;
    }
}
