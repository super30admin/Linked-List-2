// tc = sc  = O(1)
//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         if(del==null || del.next == null ) del = null;
         else{
            del.data = del.next.data;
            del.next= del.next.next;
         }
         
    }
}
