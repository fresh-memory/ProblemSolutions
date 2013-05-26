/*
*
* Heap to sort the head of all lists
* always get the head from list;
* Comparator default ascending order.
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
 public ListNode mergeKLists(ArrayList<ListNode> lists) {
            // Start typing your Java solution below
            // DO NOT write main() function
            int length = lists.size();
            if(length==0 || lists==null) return null;
            ListNode head = new ListNode(0);
            ListNode header = head;
            
      Comparator<ListNode> comp = new Comparator<ListNode>(){
             @Override
             public int compare(ListNode l1, ListNode l2){
                if(l1.val>l2.val){
                    return 1;
                }
                else if(l1.val<l2.val){
                    return -1;
                }
                else return 0;
            
            }
      };
            
            PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comp);

            for(ListNode n:lists){
                if(n!=null)   heap.add(n);
            }
            
            ListNode next=null;
                 while(!heap.isEmpty()){
                     next =heap.poll();
                     header.next=next;
                     header=header.next;
                     if(next.next!=null){
                        heap.add(next.next);
                     }
               }
           
            return head.next;
            
        } 
    
}
