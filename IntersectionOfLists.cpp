// Time Complexity :  O(n+m) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english

/* Maintain two pointers. Move the longest list pointer to abs(Size_A - Size_B) locations such that now both list pointers are in sync and will reach the end of list same time.
 * Keep moving both list pointer one node at a time, compare the node pointed by both pointers, if same return the node.
 */

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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if (headA == nullptr || headB == nullptr)
            return nullptr;
        
        ListNode* current;
        int a_size, b_size;
        a_size = b_size = 0;
        
        current = headA;
        while (current != nullptr)
        {
            a_size++;
            current = current->next;
        }
        
        current = headB;
        while (current != nullptr)
        {
            b_size++;
            current = current->next;
        }
        
        while (a_size > b_size)
        {
            headA = headA->next;
            a_size--;
        }
        
        while (a_size < b_size)
        {
            headB = headB->next;
            b_size--;
        }
        
        while (headA != headB)
        {
            headA = headA->next;
            headB = headB->next; 
        }
        return headA;
    }
};