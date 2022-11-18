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
    public ListNode insertionSortList(ListNode head) {
        if(head==null &&head.next==null)
            return head;
        ListNode start=head;
        ListNode psuodoHead=new ListNode();
        while(start!=null){
            ListNode prevSmall=psuodoHead;
            while(prevSmall.next!=null && prevSmall.next.val<start.val ){
               prevSmall=prevSmall.next;
            }
            ListNode nextStart=start.next;
            start.next=prevSmall.next;
            prevSmall.next=start;
            start=nextStart;
            
        }
        return psuodoHead.next;
    }
}