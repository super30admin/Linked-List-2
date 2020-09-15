// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. By finding the midpoint of the list we can reverse the second half of the list.
//2.Reordering the list by changing the pointers would give the desired solution. 
public class ReorderList {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int ele) {
            data = ele;
        }
    }

    public void reorderList(ListNode head) {

        if (head == null)
            return;

        ListNode slow = head, fast = head;
        // Midpoin of Linked List
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse a Linked List
        ListNode head2 = reverse(slow.next);
        slow.next = null;

        // merging two lists

        ListNode head1 = head;

        ListNode temp;
        ListNode temp2;

        while (head2 != null) {
            temp = head1.next;
            head1.next = head2;
            temp2 = head2.next;
            head2.next = temp;
            head1 = temp;
            head2 = temp2;
        }

    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;

    }

    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String args[]) {
        ReorderList obj = new ReorderList();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        obj.reorderList(list);
        obj.printList(list);

    }
}
