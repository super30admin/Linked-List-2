//TC:O(n) asymtotically, one pass for mid element,
//Running on leetcode: yes
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        //find the middle
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the portion after middle
        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;
        //merge the two lists
        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode prev = null, curr = head, fast = head.next;
        while(fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}
