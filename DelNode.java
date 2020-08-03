// Time Complexity :O(1)
// Space Complexity :O(1)

// Your code here along with comments explaining your approach
// copy next nodes info into this one, and del next node.

class GfG
{
    void deleteNode(Node node)
    {
         // Your code here
         node.data = node.next.data;
         node.next = node.next.next;
    }
}
