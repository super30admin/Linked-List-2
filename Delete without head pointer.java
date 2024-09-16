// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// we copy the value of the next node in the node to be deleted. after that we will set del node's next to del.next.next. Like that we wwere able to delete the node by simply overwriting the value of next node. Although we cannot deleted the last node. Also, we are deleting the refernce of the node. We are just overwriting the value.

//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         del.data = del.next.data;
         del.next = del.next.next; 
    }
}

