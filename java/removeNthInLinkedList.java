/* Dummy node again! 
Otherwise it is difficult to handle the very first element of the LinkedList
Testcase should cover corner case.
**
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
         if(head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
         ListNode preNode=dummy, ahead=dummy;
         while(n>0){
            ahead=ahead.next;
            n--;
         }
         
         while(ahead.next!=null){
             ahead=ahead.next;
             preNode=preNode.next;
         }
     
         ListNode temp=preNode.next.next;
         preNode.next.next=null;
         preNode.next=temp;
    return dummy.next;
    }
}
