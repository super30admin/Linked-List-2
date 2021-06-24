package LinkedList2;

public class question53_ReorderList {
    /* Created by palak on 6/23/2021 */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    /*
        Time Complexity: O(N)
        Space Complexity: O(1)
    */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow.next);
        slow.next = null;

        ListNode firstHalf = head;
        while(firstHalf != null && secondHalf != null) {
            ListNode f1 = firstHalf.next;
            ListNode s1 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = f1;

            firstHalf = f1;
            secondHalf = s1;
        }
    }
    private ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null) {
            ListNode curr = temp.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
