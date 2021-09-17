// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on GeeksforGeeks : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


//Function to delete a node without any reference to head pointer.
//1. copy data of next node to current node(the one need to be deleted)
//2. set the pointer of current node to next to next node
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         int nextval = del.next.data;
         del.data = nextval;
         del.next = del.next.next;
    }
}