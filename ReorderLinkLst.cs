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
 //Time Complexity: O(n)
 //Space Complexity: O(1)
public class Solution {
    public void ReorderList(ListNode head) {
        if (head == null) return;
            //Find the middle
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }
            //Reverse the portion after middle
            fast = ReverseList(slow.next);
            slow.next = null;
            slow = head;
            //Merge the two lists
            while (fast != null)
            {
                ListNode temp = slow.next;
                slow.next = fast;
                fast = fast.next;
                slow.next.next = temp;
                slow = temp;
            }
    }
     private ListNode ReverseList(ListNode head)
        {
            if (head == null) return head;
            ListNode prev = null, curr = head, fast = head.next;
            while (fast != null)
            {
                curr.next = prev;
                prev = curr;
                curr = fast;
                fast = fast.next;
            }
            curr.next = prev;
            return curr;
        }
}