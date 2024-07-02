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

class reorderL {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse LL
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        // merge the LL
        while (fast != null) {
            ListNode temp1 = slow.next;
            ListNode temp2 = fast.next;
            slow.next = fast;
            fast.next = temp1;
            slow = temp1;
            fast = temp2;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Return head instead of null
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        reorderL list = new reorderL();

        // Create a linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original list:");
        printList(head);

        // Reorder the list
        list.reorderList(head);

        System.out.println("Reordered list:");
        printList(head);

    }
}
