/*
Re-Order Linked List
approach: find the mid first and then reverse the list from mid+1. now, merge 2 lists.
time: O(n)
space: O(1)
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class Problem2 {

    static void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p1 = head;
        ListNode p2 = reverseList(slow.next);
        slow.next = null;

        while(p2!=null) {
            ListNode t = p1.next;
            p1.next = p2;
            p2 = p2.next;
            p1.next.next = t;
            p1= t;
        }

    }

    private static ListNode reverseList(ListNode root) {
        if (root==null || root.next==null) return root;
        ListNode curr=root, prev = null, fast = root.next;

            while(fast!=null ) {
                curr.next = prev;
                prev = curr;
                curr = fast;
                fast = fast.next;
            }
            curr.next = prev;

            return curr;
        }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        reorderList(node1);
    }
}
