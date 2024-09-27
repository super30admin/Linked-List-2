/**
 * Time Complexity : O(1)
 * Space Complexity : O(1)
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}