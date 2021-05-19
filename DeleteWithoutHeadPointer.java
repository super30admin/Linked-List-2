/* Approach: 
1. Copy next nodes data to the node that is to be deleted
2. Remove the next node by making the del.next point to del.next.next 

Time complexity: O(1)
Space complexity: O(N)
*/
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         if(del.next!=null)
         {
             del.data = del.next.data;
             del.next = del.next.next;
         }
         else
            del=null;
    }
}