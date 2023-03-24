/*the time complexity of this implementation is O(n)*/
public class Solution {
    public void deleteNode(ListNode del) {
        // Copy the next node's value and pointer to the current node
        del.val = del.next.val;
        del.next = del.next.next;
        // Delete the next node
        System.gc(); // Optional: call the garbage collector to free the memory of the deleted node
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Delete node3 from the linked list
        Solution solution = new Solution();
        solution.deleteNode(node3);

        // Print the resulting linked list: 1 -> 2 -> 4 -> 5
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
