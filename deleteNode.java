// Time Complexity : O(1)
// Space Complexity : O(1)

// delete node without head pointer

public class Solution {
    public void deleteNode(ListNode node_ref) {
        node_ref.val = node_ref.next.val;
        node_ref.next = node_ref.next.next;
        return null;
    }
}