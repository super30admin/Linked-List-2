/*
Desc : we copy the value of next node of the current node and the next pointer is copied to the current next
Naturally deleting the existing node.
Time Complexity : O(1)
Space Complexity : O(1)
*/

class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         del.data = del.next.data;
         del.next = del.next.next;
    }
}
