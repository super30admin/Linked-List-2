// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class DeleteWithoutHeadPointer {
    void deleteNode(Node del) {
        del.data = del.next.data;
        del.next = del.next.next;
    }
}