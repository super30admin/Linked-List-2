// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

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
        ListNode Prev = null;
        ListNode Curr = head;
        ListNode Next = head.next;

        while (Next != null) {
            Curr.next = Prev;
            Prev = Curr;
            Curr = Next;
            Next = Next.next;
        }
        Curr.next = Prev;
        return Curr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);

        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(head);

        // Print the reordered list
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
