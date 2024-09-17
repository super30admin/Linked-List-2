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
 //1. Find the middle of the list. n/2
 //2. Reverse the list after the middle. n/2
 //3. Merge the lists. n/2
 //Time :3/2(n) = O(n)
 //space - O(1) - constant
class Solution {
public:
    void reorderList(ListNode* head) {
        if(head == NULL || head->next==NULL || head->next->next==NULL)return;
        ListNode * slow = head;
        ListNode * fast = head;
        while(fast->next!=NULL && fast->next->next!=NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        fast = reverse_ll(slow->next);
        slow->next=NULL;
        slow = head;
        while(fast!=NULL){
            ListNode *temp = slow->next;
            slow->next= fast;
            fast = fast->next;
            slow->next->next=temp;
            slow = temp;
        }
        
    }
private:
    ListNode* reverse_ll(ListNode* head){
        ListNode *prev = NULL;
        ListNode *curr = head;
        ListNode *fast = head->next;
        while(fast!=NULL){
            curr->next = prev;
            prev = curr;
            curr = fast;
            fast = fast->next;
        }
        curr->next = prev;
        return curr;
    }    
};
