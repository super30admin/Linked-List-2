// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we traverse till mid and reverse the second half of the linkedlist.
// we join both the lists one by one each.


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
    ListNode* reverseList(ListNode* head)
    {
        if(head == NULL || head->next==NULL) return head;
        ListNode* prev = NULL;
        ListNode* curr = head;
        ListNode* temp = NULL;
        while(curr!=NULL)
        {
            temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
        
    }
    void reorderList(ListNode* head) {
        if(head ==NULL || head->next==NULL) return;
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast->next!=NULL && fast->next->next!=NULL)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
       // cout << slow->val << endl;
        fast = reverseList(slow->next);
        slow->next = NULL;
        slow = head;
        while(fast!=NULL)
        {
            ListNode* temp = fast->next;
            fast->next = slow->next;
            slow->next = fast;
            slow = slow->next->next;
            fast = temp;
        }
        
    }
    
};