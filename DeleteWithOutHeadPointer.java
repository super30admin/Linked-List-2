class GfG
{
    void deleteNode(Node node)
    {
         // Your code here
         node.data = node.next.data;
         node.next = node.next.next;
    }
}

Time Complexity: O(1)
Space Complexity: O(1)