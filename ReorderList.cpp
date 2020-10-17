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
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    void reorderList(ListNode* head) 
    {
        if(head == NULL) return;
        
        ListNode* temp = middleNode(head);
        ListNode* second = reverseList(temp);
        ListNode* first = head;
        
        while(second->next)
        {
            ListNode* after1 = first->next;
            ListNode* after2 = second->next;
            
            first->next = second;
            second->next = after1;
            
            first = after1;
            second = after2;
        }
        
    }
    
    ListNode* middleNode(ListNode* head)
    {
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast != NULL and fast->next != NULL)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        return slow;
        
    }
    
    ListNode* reverseList(ListNode* head)
    {
        ListNode* prev = NULL; 
        ListNode* after = NULL;
        ListNode* curr = head;
        
        while(curr != NULL)
        {
            after = curr->next;
            curr->next = prev;
            prev = curr;
            curr = after;
        }
        
        return prev;
        
    }
    
    
};