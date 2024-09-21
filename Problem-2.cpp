
// Time Complexity : O(n)  n is length of the linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
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

    ListNode* reverse(ListNode* head)
    {
        if(head == NULL || head->next == NULL)
            return head;
        ListNode* curr = head;
        ListNode* prev = NULL;
        ListNode* fast = head->next;
        while(fast)
        {
            curr->next = prev;
            prev = curr;
            curr = fast;
            fast = fast->next;
        }
        curr->next = prev;
        return curr;
    }

    void reorderList(ListNode* head) {
        if(head == NULL || head->next == NULL)
            return;
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast!=NULL && fast->next!= NULL)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode* reverseHead = reverse(slow->next);
        slow->next = NULL;

        slow = head;
        fast = reverseHead;

        while(fast)
        {
            ListNode* temp = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = temp;
            slow = temp;
        }
    }

    
};