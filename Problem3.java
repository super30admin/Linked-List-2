Time Complexity: O(1)
Space Complexity: O(1)
Ran successfully on GFG?: yes

class GfG
{
    void deleteNode(Node node)
    {
         // Your code here
         Node tempNextNode = node.next;
         node.data = tempNextNode.data;
         node.next = tempNextNode.next;
         tempNextNode.next = null;
    }
}
