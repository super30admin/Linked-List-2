// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on GFG : Yes
// Any problem you faced while coding this : No


/**
 * We swap the data from next node untill we are pointing to last node
 * Finally get rid of the last node as that will contain the del node value.
 */

//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         if (del.next == null) {
             return;
         }
         
         Node prev = del;
         
         while (del.next != null) {
             del.data = del.next.data;
             
             prev = del;
             del = del.next;
         }
         
         prev.next = del.next;
    }
}
