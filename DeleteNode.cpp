//TC = O(1)
//SC = O(1)

class Solution {
public:
    void deleteNode(ListNode* node) {
        node->val = node->next->val;
        //ListNode *deleteNode = node->next;
        node->next = node->next->next;
        //delete deleteNode;
    }
};
