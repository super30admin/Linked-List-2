// Time Complexity : O(n*n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    void reorderList(ListNode* head) {
        
        if(!head)
            return;
        
        if(!head->next)
            return;
        
        ListNode* first = head;
        ListNode* next;
        
        ListNode* last = head;
        ListNode* prev;

        // Find Last Node        
        while(last->next)
        {
            last = last->next;
        }
        
        // Traverse until all nodes covered
        while(first && last && first != last)
        {
            // Note the next node
            next = first->next;
            
            // Shift the next pointer
            first->next = last;
            
            // Progres the first pointer
            first = next;
            
            // Last pointer points to new first
            last->next = first;
            
            // Find the node before the current last node
            prev = first;

            // Traverse till second last node            
            while(prev->next != last)
            {
                prev = prev->next;
            }
            
            last = prev;
            last->next = NULL;
        }
    }
};