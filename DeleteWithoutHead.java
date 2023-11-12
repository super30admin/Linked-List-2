/*
    - copy the data from the next node into the current node
    - point the node to next's next
    - mark the next node as null for the garbage collector
    - TC: O(1)
    - SC: O(1)
    - works on gfg

*/

public class DeleteWithoutHead {
 
    class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         Node temp = del.next;
         del.data = del.next.data;
         del.next = del.next.next;
         temp = null;
    }
}

}
