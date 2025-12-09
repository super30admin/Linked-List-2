/*
class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/

// Time: O(1)
// Space: O(1)
class Solution {
    public void deleteNode(Node del_node) {
        // base
        if (del_node == null || del_node.next == null) {
            // cannot delete if it is the last node.
            return;
        }
        
        // logic
        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next;
    }
}