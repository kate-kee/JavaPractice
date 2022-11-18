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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head==null || head.next==null ||left==right) return head;
        ListNode dummy = new ListNode(-1,head);
        int pos=1;
        ListNode prev =dummy,curr=head,lead=head.next,start=dummy,end=dummy;
        while(pos!=left){
                pos++;
                prev=curr;
                curr=curr.next;
                //System.out.println(dummy.next.val);
        }
        start=curr;
        end=prev;
        lead=curr.next;
        int n=right-left;
        while(n-->0) {
                prev=curr;
                curr=lead;
                lead=lead.next;
                curr.next=prev;
        }
        start.next=lead;
        end.next=curr;
        return dummy.next;
    }
}