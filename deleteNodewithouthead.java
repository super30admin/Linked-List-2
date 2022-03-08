//TC: O(1)
//space:o(1)

class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         Node curr = del;
         if(curr.next != null)
         {
             curr.data = curr.next.data;
             curr.next = curr.next.next;
         }
    }
}
