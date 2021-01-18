// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on GFG : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// change next node data with current node then remove next node.

class GfG
{
    void deleteNode(Node node)
    {
         // Your code here
         node.data = node.next.data;
         Node temp = node.next; // to avoid memory leak
         temp.next = null;
         node.next = node.next.next;

    }
}