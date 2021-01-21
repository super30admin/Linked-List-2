// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class DeleteWithNoHead
{
    void deleteNode(Node node)
    {
        // Your code here
        Node temp = node.next;
        //change val to next's val
        node.data = node.next.data;
        //change connection to node after
        node.next = node.next.next;
        //remove connection for node to be removed
        temp.next = null;
    }
}