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
        if(head->next == NULL){
            return ;
        }
        
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast->next != NULL && fast->next->next != NULL){
            fast = fast->next->next;
            slow = slow->next;
        }
                                    ///////////
       fast = reverse(slow->next);
       slow->next = NULL;
        
                                    /////////////
        slow = head;
        ListNode* temp = head;
        ListNode* temp2 = fast;
        
        while(temp !=NULL && temp2 !=NULL){
        temp = slow->next;
        slow->next = fast;
        temp2 = fast->next;
        fast->next = temp;
        slow= temp;
        fast = temp2;
    }
    }
        
        ListNode* reverse(ListNode* &head){
        ListNode* prev = NULL;
        ListNode* curr = head;
        ListNode* fwd = head->next;
        
            while( fwd !=NULL){
                curr->next = prev;
                prev = curr;
                curr = fwd;
                fwd = fwd->next;
            }
            curr->next = prev;
             return curr;
            
        }
};
