//time complexity: O(n) we traverse all elements of the linked list in finding out middle, then traverse half elements while reversing the second half and again traverse all elements while joining the two lists.
//space complexity : O(1)
//executed on leetcode: yes

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
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode slow = head;
        ListNode fast = slow;
        while(fast!=null && fast.next!=null) //we find out the middle of the linked list
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode current = slow;
        ListNode prev=null;
        while(current!=null) //we reverse the second half of the list
        {
            ListNode next_node = current.next;
            current.next = prev;
            prev=current;
            current = next_node;
        }
        ListNode head2 = prev;
        while(head2.next!=null) //we merge the two linked lists
        {
            ListNode temp = head.next;
            head.next = head2;
            head = temp;
            temp = head2.next;
            head2.next= head;
            head2 = temp;
        }
    }
}