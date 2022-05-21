// Time Complexity : O(1) function
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : on Geeks for Geeks yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
       del->data = del->next->data; // replace data with next value's data
       del->next = del->next->next; / adjust next pointers
    }

};