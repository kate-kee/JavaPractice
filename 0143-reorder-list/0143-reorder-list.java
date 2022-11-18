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
    ListNode p;
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

    ListNode prev = null, curr1 = slow, tmp;
    while (curr1 != null) {
      tmp = curr1.next;
      curr1.next = prev;
      prev = curr1;
      curr1 = tmp;
    }
        ListNode curr=head;
        ListNode second=prev;
        
        while(second.next!=null){
          ListNode currNext=curr.next;
          curr.next=second;
          curr=currNext;
          currNext=second.next;
          second.next=curr;
          second=currNext;
        }
        
    }
}