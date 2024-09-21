// Time Complexity : O(1) since we just interchange pointers and modify value in given del_node
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
  public:
    // Function to delete a node without any reference to the head pointer.
    void deleteNode(Node* del_node) {
        // Your code here
        del_node->val = del_node->next->val;
        del_node->next = del_node->next->next;
    }
};