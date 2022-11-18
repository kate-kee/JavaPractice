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
    public ListNode deleteMiddle(ListNode head) {
        ListNode prev=null,one=head,two=head;
        if(head.next==null)
            return null;
        while(two!=null && two.next!=null){
            prev=one;
            one=one.next;
            two=two.next.next;
        }
        prev.next=one.next;
    return head;
    }
    
}