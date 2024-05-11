// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution
{
    void deleteNode(Node del_node)
    {
        Node temp = del_node.next;
        del_node.data = temp.data;
        del_node.next = temp.next;
        temp = null;
    }
}
