// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
public class DeleteWithoutHead {
    void deleteNode(Node node) {
        while (node.next.next != null) {
            node.data = node.next.data;
            node = node.next;
        }
        node.data = node.next.data;
        node.next = null;
    }
}
