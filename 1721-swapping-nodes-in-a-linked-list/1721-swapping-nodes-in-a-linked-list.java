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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode front=head;
        ListNode back=head;
        while(k!=1){
            front=front.next;
            k--;
        }
        ListNode replaceK=front;
        while(front.next!=null){
            front=front.next;
            back=back.next;
        }
        int temp=replaceK.val;
        replaceK.val=back.val;
        back.val=temp;
        return head;
    }
}