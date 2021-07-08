// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Copy the next node value into the current node. Delete the next node.
*/
{
    void deleteNode(Node node)
    {
        node.data = node.next.data;                 // Copy the value of the next node
        node.next = node.next.next;                 // Delete the next node
    }
}