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

//Time complexity : O(n)
//Space complexity : O(1)
//Leetcode : Yes
// Approach : 
            // Find midpoint of the linked list
            // Reverse the second half of the linked list and treat it as a different linked list
            // Merge the two lists

class Solution {
public:
    void reorderList(ListNode* head) {
        if(head == nullptr || head->next == nullptr) return;
        
        //Find midpoint
        ListNode* slow = head;
        ListNode* fast = head->next;
        
        while(fast != nullptr && fast->next != nullptr)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
     
        //Reverse the list
        fast = reverseList(slow->next);
        slow->next = nullptr;
        slow = head;
        ListNode* dummy = head;
        //Merge the two lists
        while(dummy != nullptr && fast != nullptr)
        {
            dummy = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = dummy;
            slow = dummy;
        }
    }
    
    ListNode* reverseList(ListNode* head)
    {
        if(head == nullptr || head->next == nullptr)
        {
            return head;
        }
        
        ListNode* rList = reverseList(head->next);
        head->next->next = head;
        head->next = nullptr;
        
        return rList;
    }
};