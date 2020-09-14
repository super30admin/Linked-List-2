// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */


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