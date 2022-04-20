//time complexity : o(n);

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
        
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast->next !=NULL && fast->next->next != NULL) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        fast = reserve(slow->next);
        slow->next = NULL;
        
        slow = head;
        
        ListNode* temp = NULL;
        while(fast != NULL) {
             
            temp = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next =temp;
            slow = temp;
        }
        
    }
    
    ListNode* reserve(ListNode* head) {
        
        if (head == NULL || head->next == NULL) return head;
        ListNode* prev = NULL;
        ListNode* curr = head;
        ListNode* fast = head->next;
        
        while(fast != NULL) {
            
            curr->next = prev;
            prev  = curr;
            curr = fast ;
            fast = fast->next;
        }
        
        curr->next = prev;
        return curr;
        
    }
    
};