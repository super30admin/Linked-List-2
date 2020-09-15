/* https://leetcode.com/problems/delete-node-in-a-linked-list/
237. Delete Node in a Linked List - EASY
TC: O(1)
SC: O(1)
Approach: copy the value of the next node into the node to be deleted, and delete the next node
by pointing curr node to link to node after next node.
*/

public class DeleteNode {
    public static void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    public static void main(String args[]) {
        ListNode head1 = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        head1.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        
        head1.print();

        deleteNode(two);
        head1.print();
    }
}
