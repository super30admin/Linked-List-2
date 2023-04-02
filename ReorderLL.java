//Leetcode - 142
//TC: O(N)
//SC: O(1)
public class ReorderLL {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        //Find middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse the second half of LL
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        //merge
        while(fast!=null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode fast = node.next;
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
