//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         Node temp = del.next;
         //del.next = null;
         del.data = temp.data;
         //del.next = temp;
         del.next = temp.next;
         temp = null;
         
    }
}
