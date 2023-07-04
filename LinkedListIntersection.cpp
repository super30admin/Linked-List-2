// Time Complexity: O(n)
// Space Complexity: O(n)
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
        map<ListNode*, int> mp; 
        ListNode* ptr = headA; 
        
        while(ptr != nullptr) {
            mp[ptr] = 1;
            ptr = ptr->next;  
        }

        ptr = headB; 

        while(ptr != nullptr) {
            if(mp[ptr] != 0) {
                return ptr; 
            }
            ptr = ptr->next; 
        }

        return nullptr; 

    }
};