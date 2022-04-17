// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH:
Intuition is to have the same valued node in the list in continuing manner.
We delete the next node from the del node but change the value of the current node to the next node and point the curr nodes next to curr nodes next to next
 */

public class DeleteWithoutHead {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    static void deleteNode(ListNode del) {
        ListNode next = del.next;
        del.val = next.val;
        del.next = next.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(3);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(0);
        ListNode next3 = new ListNode(-4);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = null;

        System.out.println("Before Deleting ");
        printList(head);

        deleteNode(head);
        System.out.println("");
        System.out.println("After deleting ");
        printList(head);

    }
}
