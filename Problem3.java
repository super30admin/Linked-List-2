// Time Complexity : O(1) we only change pointer to the node
// Space Complexity : O(1) not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem3 {
    void deleteNode(Node del)
    {
        // Your code here
        Node next = del.next;
        del.data = next.data;
        del.next = next.next;
    }
}
