// Time - O(1)
// Space - O(1)

class Solution
{
    void deleteNode(Node del)
    {
        // Your code here

        // store the next node data in the temp and point the pointer to the next of 4 which is 30
        Node temp = del.next;
        del.data = temp.data;
        del.next = temp.next;
    }
}