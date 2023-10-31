// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class DeleteNodeWithoutHead
{
    void deleteNode(Node del)
    {
        Node curr = del;
        Node prev = null;

        while(curr.next != null)
        {
            curr.data = curr.next.data;
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
    }
}
