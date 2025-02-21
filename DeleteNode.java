// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class DeleteNode {
    void deleteNode(Node node) {
        if (node == null || node.next == null) {
            return;
        }

        Node nextNode = node.next;
        node.data = nextNode.data;

        node.next = nextNode.next;
    }
}
