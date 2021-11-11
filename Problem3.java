// Problem 3 -> Delete without head pointer
// Time - O(1)
// Space - O(1)

class Solution
{
    void deleteNode(Node del)
    {
        del.data = del.next.data;
        del.next = del.next.next;
         // Your code here
    }
}