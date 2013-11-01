/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
 
 
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
            if(head == null) return null;
            RandomListNode cur = head;
            RandomListNode newHead = null;
            
            while(cur != null) {
                RandomListNode cp = new RandomListNode(cur.label);
                RandomListNode realNext = cur.next;
                cur.next = cp;
                cp.next = realNext;
                cur = realNext;
            }
        cur = head;    
        while(cur != null) {
            if(cur.random == null) { 
                //random pointer can point to null
                cur = cur.next.next; 
                continue;
            }
            cur.next.random = cur.random.next;
            cur = cur.next.next;
        }    
        cur = head;
        newHead = head.next;
        while(cur != null) {
            RandomListNode cpNext = cur.next;
            if(cpNext == null) break;
            cur.next = cpNext.next;
            cur = cpNext;
        }
        //cur.next = null;
        return newHead;
    }
}
