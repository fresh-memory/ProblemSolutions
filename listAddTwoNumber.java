/***
* Code concise 
* Becareful about what goes to remiander what goes to carry!!!
* don't be stupid!!!
*
*  
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
         
        // if(l1==null || l2==null){
         //    return null;
        // }
        ListNode newHead=null, currNode=null, newNode=null;
        int carry=0,sum=0,remainder=0;
        int l1_value=0, l2_value=0;
        while(l1!=null || l2!=null ||carry!=0){
            
            
            l1_value=l1==null?0:l1.val;
            l2_value=l2==null?0:l2.val;
            sum=l1_value+l2_value+carry;
            remainder=sum%10;
            carry=sum/10;
            if(newHead==null){
                newHead = new ListNode(remainder);
               currNode=newHead;
            }
            else{
                currNode.next  = new ListNode(remainder);
                
                currNode=currNode.next;
            }
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
            
        }
        
        return newHead;
    }
}
