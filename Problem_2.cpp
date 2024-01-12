/*
 ? Problem: Reorder List
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    void reorderList(ListNode* head) {

        if(!head) return;

        ListNode *slow = head, *fast = head, *prev = nullptr;

        while(fast->next && fast->next->next){
            fast = fast->next->next;
            slow = slow->next;
        }

        while(slow){
            fast = slow->next;
            slow->next = prev;
            prev = slow;
            slow = fast;
        }
        slow = prev;

        while(slow && head) {
            fast = head->next;
            prev = slow->next;
            head->next = slow;
            slow->next = fast;
            head = fast;
            slow = prev;
        }

    }
};