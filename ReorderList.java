// Time Complexity : O(n) as we will traverse parts of the list as follows: O(n/2 + n/2 + n)
// Space Complexity : O(1) as we're not using any auxiliary data structure
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        //find the middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the middle.next to end lis
        fast = reverse(slow.next);
        //break the link between the two halves
        slow.next = null;
        //reset heads
        slow = head;

        //merge
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode fast = head.next;
        while(fast != null){
            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;
        }
        current.next = prev;
        return current;
    }
}