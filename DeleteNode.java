/**
 * You are given a pointer/ reference to the node which is to be deleted from
 * the linked list of N nodes. The task is to delete the node. Pointer/
 * reference to head node is not given.
 * 
 * Note: No head reference is given to you.
 * 
 * Space Complexity: O(1)
 * Time Complexity: O(1)
 * 
 * Number of Leetcode Attempts: 1
 * 
 * Leetcode Results:
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
 * Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Delete Node in a Linked List.
 */
public class DeleteNode {
    private void deleteNode(Node node) {
        // simple pointer rearrangements.
        node.data = node.next.data;
        node.next = node.next.next;
    }
}