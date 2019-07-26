//
// Created by shazm on 7/25/2019.
//

#include <iostream>
#include <algorithm>

// Runtime: O(1)
// Space: O(1)
// Approach: assign to the next value.

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    void deleteNode(ListNode* &node) {
        node->val = node->next->val;
        node->next = node->next->next;
    }
};

int main(){
    Solution s;

    return 0;
}