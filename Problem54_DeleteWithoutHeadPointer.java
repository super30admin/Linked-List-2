// Time Complexity : O(1)
// Space Complexity : O(1)
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
        Node temp = del.next;
        del.data = temp.data;
        del.next = temp.next;
        temp = null;
    }
}