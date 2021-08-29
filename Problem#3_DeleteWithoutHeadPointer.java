//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         //As we know here we don't have access to previous node
         //then how to get this node deleted
         //Algorithm here: Copy the next node to curr node
         //Base case
         
        Node prev = del;
        while(del.next!=null){
            del.data = del.next.data;
            prev = del;
            del = del.next;
        }
        prev.next = null;
         
    }
}