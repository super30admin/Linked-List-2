// Problem GFG. Delete without head pointer
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class DeleteNode {
    void deleteNode(Node del_node)
    {
        // Your code here
        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next;
    }
}
