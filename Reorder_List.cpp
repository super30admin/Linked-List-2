/*
Time Complexity: O(n)(n/2:To find mid element of linked list,n/2: To reverse half linked list, n/2: To merge 2 half likedlists.) 
Space Complexity: O(1)(Storage:Few variables used, not n variables.)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
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
    ListNode *midElement(ListNode* node){
        ListNode *slow = node;
        ListNode *fast = node;
        while(fast->next!=NULL&&fast->next->next!=NULL){
            slow=slow->next;
            fast=fast->next->next;
        }
        return slow;
    }
    ListNode *reverseList(ListNode* node){
        ListNode *prev = NULL;
        ListNode *curr = node;
        while(curr!=NULL){
        ListNode *temp = curr->next;
        curr->next = prev;
        prev=curr;
        curr=temp;
        }
        return prev;
    }
    void reorderList(ListNode* head) {
        ListNode *mid = midElement(head);
        ListNode *reverse = reverseList(mid->next);
        mid->next=NULL;
        while(reverse!=NULL){
            ListNode *temp = reverse->next;
            reverse->next = head->next;
            head->next = reverse;
            head=head->next->next;
            reverse=temp;
        }
    }
    
};