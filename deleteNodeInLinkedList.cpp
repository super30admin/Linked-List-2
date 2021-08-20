// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
       if(del == NULL){
           return;
       }
       del->data = del->next->data;
       del->next = del->next->next;
    }

};
