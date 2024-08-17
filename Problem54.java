// Time Complexity : O(1)
// Space Complexity : O(1)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Problem54 {
    public void deleteNode(ListNode node) {
        // Copy the value from the next node to the current node
        node.val = node.next.val;
        // Point the current node to the node after the next node
        node.next = node.next.next;
    }
}
