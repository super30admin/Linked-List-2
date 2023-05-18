// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we replace the data in the current node with next node's data and then we delete the next node and connect all other nodes to current node.

class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
       // Your code here
       if(del == NULL && del->next == NULL) return;
       del->data = del->next->data;
       Node * temp = del->next;
       del->next = temp->next;;
       delete temp;
    }

};