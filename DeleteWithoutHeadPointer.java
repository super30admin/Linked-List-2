class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

// TC: O(1): as the traversing is not required. Just copying the next nodes
// value in current.
// SC: O(1) : no extra space is required for copying.
public class DeleteWithoutHeadPointer {
    static ListNode node1 = new ListNode(1);
    static ListNode node2 = new ListNode(10);

    public static void main(String[] args) {
        node1.next = new ListNode(2);
        ListNode dummy = node1;
        while (dummy != null) {
            System.out.print(dummy.val + " ");
            dummy = dummy.next;
        }
        System.out.println();
        deleteNode(node1);
        dummy = node1;
        while (dummy != null) {
            System.out.print(dummy.val + " ");
            dummy = dummy.next;
        }
        System.out.println();
        node2.next = new ListNode(20);
        node2.next.next = new ListNode(4);
        node2.next.next.next = new ListNode(30);
        ListNode dummy1 = node2;
        while (dummy1 != null) {
            System.out.print(dummy1.val + " ");
            dummy1 = dummy1.next;
        }
        System.out.println();
        deleteNode(node2.next);
        dummy1 = node2;
        while (dummy1 != null) {
            System.out.print(dummy1.val + " ");
            dummy1 = dummy1.next;
        }
    }

    private static void deleteNode(ListNode node) {
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
