// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class Solution {
    public void deleteNode(ListNode del_node) {
        if (del_node == null || del_node.next == null) return;
        
        // Copy the value of the next node into the current node
        del_node.val = del_node.next.val;
        
        // Skip the next node by linking to next of next
        del_node.next = del_node.next.next;
    }
}

/*
Time Complexity: O(1) 
- We perform constant operations (copy value & adjust pointer).

Space Complexity: O(1) 
- No extra space is used.
*/



public class Main {
    public static void main(String[] args) {
        // Test case 1: Deleting node with value 1 from list [1 -> 2]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        new Solution().deleteNode(head1);
        printList(head1); // Expected Output: 2

        // Test case 2: Deleting node with value 20 from list [10 -> 20 -> 4 -> 30]
        ListNode head2 = new ListNode(10);
        head2.next = new ListNode(20);
        head2.next.next = new ListNode(4);
        head2.next.next.next = new ListNode(30);
        new Solution().deleteNode(head2.next); // Delete node with value 20
        printList(head2); // Expected Output: 10 -> 4 -> 30
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
