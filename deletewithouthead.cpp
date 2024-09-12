//Time Complexity : O(1)
//Space complexity : O(1)

//Leetcode : Ran on geeksforgeeks

//Approach :
            // We have access to the node to be deleted
            // Copy contents of the next node to the current node
            // Set the next of current node to next of next node

class Solution
{
    public:
    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node *del)
    {
       // Your code here
       
       if(del == nullptr || del->next == nullptr)
       {
           del = nullptr;
           return;
       }
       
       del->data = del->next->data;
       del->next = del->next->next;
    }

};