// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//copy the data from the next node to the node to be deleted and delete the next node

class GfG
{
    public void deleteNode(Node Node_ptr)
    {
        Node temp = Node_ptr.next;
        Node_ptr.data = temp.data;
        Node_ptr.next = temp.next;
        temp = null;
    }
}