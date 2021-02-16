// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class GfG {
    void deleteNode(Node node) {
        Node next = node.next;

        node.data = next.data;

        node.next = next.next;
    }
}