public class nonrecursive_merge_sorted_list {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode curr= l1.val<l2.val?l1:l2;
        ListNode head = curr;
        while((l1!=null) && (l2!=null)){
            if(curr==l1){
                l1=l1.next;
            }
            else {
                l2=l2.next;
            }
            if(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
            }
            else{
                curr.next=l2;
            }
            curr=curr.next;
            }
        }
        if(l1==null) curr.next=l2;
        else curr.next =l1;
        
        return head;
    }
}
