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

 /* Time Complexity : O(n)
  *  n - length of the linked list */
/* Space Complexity : O(1) */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        //Find the mid of the list - by initializing two pointers at head and 
        //incrementing slow pointer by 1X and fast pointer by 2X
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reversing the list right side of mid
        fast = reverseList(slow.next);
        slow.next = null;
        //Merge both the lists
        //reset the pointers to heads of lists;
        slow = head;

        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head.next;

        while(temp != null){
            curr.next = prev;
            prev = curr;
            curr = temp;
            temp = temp.next;
        }
        
        curr.next = prev;
        return curr;
    }

}