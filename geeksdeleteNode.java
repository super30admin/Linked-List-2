//Function to delete a node without any reference to head pointer, runs and accepted by geeks for geeks
class Solution
{
    void deleteNode(Node del)
    {
         if(del == null || del.next == null) {
             return; 
         }
         del.data = del.next.data;
         del.next = del.next.next;
    }
}