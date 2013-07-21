public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode cur=head;
        while(cur!=null){
            ListNode dedup = cur.next;
            while(dedup!=null && dedup.val==cur.val) dedup=dedup.next;
            if(dedup==null) cur.next=null;
            else cur.next=dedup;
        cur=cur.next;
        }
     return head;    
    }
