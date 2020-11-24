/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// Time complexity is O(n) - n = #elements in linked list
// Space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* node = headA;
        int lenA = 0;
        int lenB = 0;
        
        while(node) {
            lenA++;
            node = node->next;
        }
        
        node = headB;
        while(node) {
            lenB++;
            node = node->next;
        }
        
        while(lenA > lenB) {
            headA = headA->next;
            lenA--;
        }
        
        while(lenB > lenA) {
            headB = headB->next;
            lenB--;
        }
        
        while(headA != headB) {
            headA = headA->next;
            headB = headB->next;
        }
        return headA;
    }
};

// Using set

// Time complexity is O(n) - n = #elements in linked list
// Space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        set<ListNode*> set;
        ListNode* node = headA;
        while(node) {
            if(set.find(node) == set.end()) {
                set.insert(node);
            }
            node = node->next;
        }
        node = headB;
        while(node) {
            if(set.find(node) != set.end()) {
                return node;
            }
            node = node->next;
        }
        return node;
    }
};
