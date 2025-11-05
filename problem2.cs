/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public void ReorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null)
        {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        ListNode head1 = slowPtr.next;
        slowPtr.next = null;
        ListNode prev = null;
        ListNode current = head1;
        ListNode temp = current.next;

        while(temp!= null)
        {
            current.next = prev;
            prev= current;
            current = temp;
            temp = temp.next;
        }
        current.next = prev;
        ListNode reversedHead = current;
        while(reversedHead != null)
        {
            ListNode temp1 = head.next;
            head.next = reversedHead;
            reversedHead = reversedHead.next;
            head.next.next = temp1;
            head = temp1;
        }
        
        
    }
}