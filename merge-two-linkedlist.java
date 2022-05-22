class Solution {
    // Time complexity is O(n)
    // Space complexity is O(1)
    // This solution is submitted on leetcode with zero errors.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
        }
    }
    public void reorderList(ListNode head) {
        // Step 1: To find the mid node
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Step 2: Reverse the link list
        fast = reverseList(slow.next);
        //break the node
        slow.next = null;
        slow = head;
        // Step 3: Merge the two Linked List
        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverseList(ListNode head) {
        //egde case
        if (head ==null) return head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null){
            slow.next = prev;
            prev = slow;
            slow = fast;
            fast = fast.next;
        }
        slow.next = prev;
        return slow;
    }
}