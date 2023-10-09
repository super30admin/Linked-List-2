class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Find middle of Linked List
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode reversed = reverseList(slow.next);
        slow.next = null;
        slow = head;

        while (reversed != null) {
            ListNode temp = slow.next;
            slow.next = reversed;
            reversed = reversed.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;

        while (fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }

    public static void main(String[] args) {
        // Create a linked list for testing
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Reorder the linked list
        solution.reorderList(node1);

        // Print the reordered linked list
        while (node1 != null) {
            System.out.print(node1.val + " -> ");
            node1 = node1.next;
        }
        System.out.println("null");
    }
}
