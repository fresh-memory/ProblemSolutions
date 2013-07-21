/*
*
* Stack+ Recursive ...
* First establish the basic procedure then recursive----tail recursion top down
*Corner case when head =null but count=k
*  call isEmpty() before peek() pop() etc...
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
         ListNode newHead = new ListNode(0);
          newHead.next=head;
        if(head==null || k<2) return newHead.next;
      return reverseHelper(newHead, head, k);
       
    }
    
     public ListNode reverseHelper(ListNode nHead, ListNode head, int k) {
            //need to pass new reference down otherwise nHead will be modified
            ListNode newHead = nHead;
            Stack<ListNode> stk = new Stack<ListNode>();
        int count=0;
        while(head!=null && count<k){
            stk.push(head);
            head=head.next;
            count++;
        }
        //must &&
        if(head==null && count<k) return nHead.next;
       // It is possible that count==k and head ==null when k =size of the linkedlist
       if(count==k) {
            newHead.next= stk.peek();
            while(!stk.isEmpty()){
                ListNode temp = stk.pop();
                
                //if(stk.peek()!=null){
                if(!stk.isEmpty()){
                temp.next =stk.peek();
                }
                else{
                    temp.next=head;
                    newHead=temp;
                }
                
            }
        }
        
          reverseHelper(newHead, head, k);   
          return nHead.next;
    
     }
    
}
