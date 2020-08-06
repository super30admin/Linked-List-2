//Time Complexity-O(n)
//Space Complexity-O(1)
//Runs successfully on leetcode

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
        //edge case
        if(head == NULL || head->next == NULL) return;
        //find the mid of the linkedlist
        
        ListNode* slow =head; ListNode* fast = head;
        while(fast->next != NULL && fast->next->next != NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        fast= reverse(slow->next);
        slow->next = NULL;
        slow = head;
        //merge the list
        
        ListNode* curr;
        while(fast != NULL){
            curr = slow->next;
            slow->next= fast;
            fast = fast->next;
            slow->next->next = curr;
            slow = curr;
        }
        
        
        
    }
    ListNode* reverse(ListNode* head){
        ListNode* prev = NULL;
        ListNode* curr = head;
        ListNode* fast = head->next;
        while(fast !=NULL){
            curr->next = prev;
            prev = curr;
            curr = fast;
            fast = fast->next;
        }
        curr->next = prev;
        return curr;
        
    }
};