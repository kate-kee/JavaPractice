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
    public ListNode mergeKLists(ListNode[] lists) {
     ListNode sentinel = new ListNode();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                System.out.println(list.val);
                queue.add(list.val);
                list = list.next;
            }
        }

        ListNode current = sentinel;
        while (!queue.isEmpty()) {
            current.next = new ListNode(queue.poll());
            current = current.next;
        }

        return sentinel.next;
    }
}