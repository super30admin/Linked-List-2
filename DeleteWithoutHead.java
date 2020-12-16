/**
 * Time Complexity: O(1), Space Complexity: O(1)
 * Approach: 
 * As the node to be deleted is not the the tail node, just copy the next node's data into given node.
 * After copying, delete the next node
 */

class DeleteWithoutHead
{
    void deleteNode(Node node)
    {
         // copy the next node's data into given node
         node.data = node.next.data;
         // delete the next node
         node.next = node.next.next;
    }
}
