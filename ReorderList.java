// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ReorderList {
    // Brute Force
    public void reorderList(ListNode head) {
        if(head == null){
            return ;
        }
        ListNode headNode = head;
        while(headNode.next != null){
            ListNode temp = reverse(headNode.next);
            headNode.next = temp;
            headNode = headNode.next;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode temp = null;
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
