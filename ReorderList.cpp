// Time Complexity :  O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english

/* Find mid of list using slow and fast pointer method. Move slow pointer one node and fast two nodes until fast is not null.
 * Reverse the second half of list.
 * Merge the above two lists.
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        if (head == nullptr || head->next == nullptr)
            return;
        
        ListNode* slow = head;
        ListNode* fast = head->next;
        
        // Find mid of list.
        while (fast != nullptr && fast->next != nullptr)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        // Reverse second half
        fast = reverse(slow->next);
        slow->next = nullptr;
        
        ListNode* dummy = head->next;
        slow = head;
        
        while (fast != nullptr)
        {
            slow->next = fast;
            fast = fast->next;
            slow->next->next = dummy;
            slow = dummy;
            
            if (slow == nullptr)
                break;
            
            dummy = dummy->next;
        }
    }
    
    ListNode* reverse(ListNode* head)
    {
        ListNode* prev = nullptr;
        ListNode* cur = head;
        ListNode* fast = head->next;
        
        while (fast != nullptr)
        {
            cur->next = prev;
            prev = cur;
            cur = fast;
            fast = fast->next;
        }
        cur->next = prev;
        
        return cur;
    }
};