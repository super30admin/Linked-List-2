/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 Time Complexity = O(N)
 Space Complexity = O(1)
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        if(head==NULL)
            return;
        ListNode* slow = head;
        ListNode* fast = head;
        //find the middle
        while(fast!=NULL && fast->next!=NULL)
        {
            fast=fast->next->next;
            slow=slow->next;
        }
        fast = slow->next;                                                //assign the head of the linked list from the element next to the middle to fast.
        slow->next = NULL;                                                //assign the last elements->next of the first linked list NULL.
        slow = head;                                                      //assign the head of the first linked list to slow.  
        //reverse the list from the middle's next. 
        ListNode* prev = NULL;
        ListNode* curr = fast;
        ListNode* next;
        while(curr!=NULL)
        {
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        fast = prev;
        //merge
        ListNode* temp;
        while(fast!=NULL)
        {
            temp = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = temp;
            slow = temp; 
        }
    }
};
