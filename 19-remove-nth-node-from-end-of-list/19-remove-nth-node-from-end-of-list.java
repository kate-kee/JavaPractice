/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode nsteps,remove;
        nsteps=head;
        remove=head;
        while(n!=0){
            nsteps=nsteps.next;
            n--;
        }
        while(nsteps!=null && nsteps.next!=null){
            nsteps=nsteps.next;
            remove=remove.next;
        }
        if( nsteps==null)
            return head.next;
        remove.next=remove.next.next;
    return head;
    }
}