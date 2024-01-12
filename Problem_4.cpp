/*
 ? Problem: Intersection of two linked list
 * Time Complexity : O(n + m)
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* p1 = headA;
        ListNode* p2 = headB;
        int l1 = 0, l2 = 0;

        while (p1 != nullptr) l1++, p1 = p1->next;
        while (p2 != nullptr) l2++, p2 = p2->next;

        p1 = headA;
        p2 = headB;
        if (l1 > l2) {
            int diff = l1 - l2;
            while (diff > 0) { p1 = p1->next; diff--; }
        } else {
            int diff = l2 - l1;
            while (diff > 0) { p2 = p2->next; diff--; }
        }

        while (p1 != nullptr && p2 != nullptr) {
            if (p1 == p2)
                return p1;
            p1 = p1->next;
            p2 = p2->next;
        }

        return nullptr;
    }
};