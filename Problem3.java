/**
 * Time complexity - O(1)
 * Space complexity - O(1)
 */
class GfG
{
    void deleteNode(Node node)
    {
        // Your code here
        if(node.next==null)
            node=null;
        node.data = node.next.data;
        node.next = node.next.next;
    }
}