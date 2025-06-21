// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class ReorderList {
    static class ListNode1 {
        int val;
        ListNode1 next;

        ListNode1(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class LinkedList1 {

        static void reorderList(ListNode1 head) {
            ListNode1 slow = head;
            ListNode1 fast = head;

            while(fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            fast = reverse(slow.next);
            slow.next = null;
            slow = head;
            while(fast != null) {
                ListNode1 temp = slow.next;
                slow.next = fast;
                fast = fast.next;
                slow.next.next = temp;
                slow = temp;
            }
        }
        static ListNode1 reverse(ListNode1 curr) {
            ListNode1 prev = null;
            while(curr != null) {
                ListNode1 temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }

        static void printList(ListNode1 head) {
            ListNode1 current = head;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
                if(current != null) System.out.print("-> ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ListNode1 node1 = new ListNode1(1);
        ListNode1 node2 = new ListNode1(2);
        ListNode1 node3 = new ListNode1(3);
        ListNode1 node4 = new ListNode1(4);
        ListNode1 node5 = new ListNode1(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println("Before Reordering: ");
        LinkedList1.printList(node1);

        System.out.println("After Reordering: ");
        LinkedList1.reorderList(node1);
        LinkedList1.printList(node1);

    }
}
