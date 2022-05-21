// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
        // to make the last node adj after copying values one level up
        Node prev = null;
        while(del != null && del.next != null) {
            del.data = del.next.data;
            prev = del;
            del = del.next;
        }
        prev.next = null;

    }
}