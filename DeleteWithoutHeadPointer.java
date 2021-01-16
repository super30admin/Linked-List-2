// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Copy the value of the next node in the current node, and then delete the next node.

public class DeleteWithoutHeadPointer {
    void deleteNode(Node node)
    {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
