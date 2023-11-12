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


 /*
  - step 1: find the middle node in the linkedlist
  - step 2: reverse the list from that node
  - step 3: merge the reversed list and original list alternatively to create reordered list

  -TC: O(n)
  - SC: O(1)
 */

class Solution {
    public void reorderList(ListNode head) {

        //null
        if(head == null || head.next == null || head.next.next == null) return;

        //find middle
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null && fast.next.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow will be at my middle
        //reverse linkedlist
        fast = reverseLinkedList(slow.next);
        slow.next = null;
        //merging the list
        slow = head;
       
        while(fast!=null)
        {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }

    public ListNode reverseLinkedList(ListNode head)
    {

        if(head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev =  null;
        ListNode temp = curr.next;

        while(temp != null)
        {
            curr.next = prev;
            prev = curr;
            curr = temp;
            temp = temp.next;
        }

        curr.next = prev;
        return curr;

    }
}