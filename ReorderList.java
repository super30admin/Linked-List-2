// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


//slow and fast pointer to find the middle and reverse the second half
//iterate the both pointers and reorder from slow to fast

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class ReorderList {
    

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        while (fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // Creating a sample linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Creating an instance of ReorderList
        ReorderList reorderList = new ReorderList();

        // Reordering the list
        reorderList.reorderList(head);

        // Printing the modified list
        System.out.println("Reordered List:");
        printList(head);
    }
}
