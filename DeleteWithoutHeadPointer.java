/* Structure of linked list Node
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
class Solution {
    public void deleteNode(Node del_node) {
        //TC - O(1)
        // SC - O(1)
        // Copy the value of the next node into the given node (del_node).
        del_node.val = del_node.next.val;
        // Update del_node.next to skip the next node:
        del_node.next = del_node.next.next;
    }
}