// Time Complexity: O(1)
// Space Complexity: O(1)

/*
class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
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