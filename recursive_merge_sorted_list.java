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
public class recursive_merge_sorted_list {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode curr= l1.val<l2.val?l1:l2;
        ListNode head = curr;
        if(curr==l1){
            l1=l1.next;
        }
        else {
            l2=l2.next;
            
        }
        curr.next=mergeTwoLists(l1,l2);
        return head;
    }
}
