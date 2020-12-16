/*
 Time Complexity : O(1)
 Space Complexity : O(1)
 Idea : copy the next node data in current and delete the next node.
*/
class GfG
{
    void deleteNode(Node node)
    {
         // Your code here
         Node next = node.next;
         node.data = next.data;
         node.next = next.next;
         next = null;
    }
}