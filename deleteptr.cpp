//T: O(n)
//S: O(1)
class Solution {
public:
    void deleteNode(ListNode* node) {
        ListNode* curr = node;
        ListNode* prev = nullptr;
        while(curr->next){
            curr->val = curr->next->val;
            prev = curr;
            curr = curr->next;
        }
        prev->next = nullptr;
    }
};