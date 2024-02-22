// TC = O(N/2) +  O(N/2) + O(N) ~ O(N)
// SC = O(1)
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
    void reorderList(ListNode* head) {
        // TC = O(N/2) +  O(N/2) + O(N) ~ O(N), SC = O(1)
        // null
        if(head == NULL || head->next == NULL) return;
        // 1. find mid
        ListNode *slow = head, *fast = head;
        // for odd go to mid, for even go to mid - 1, so next & next.next != null
        while(fast->next != NULL && fast->next->next != NULL) {
            slow = slow->next;
            fast = fast->next->next;
        }
        // 2. reverse LL
        fast = reverse(slow->next);
        // 3. Merge 2 LLs
        slow->next = NULL;
        slow = head;
        ListNode *temp = NULL;
        while(fast != NULL) { // only check for fast, as in odd fast will 1st become null & in even both will become null together
            temp = slow->next; // taking only 1 extra pointer will work
            slow->next = fast;
            fast = fast->next;
            slow->next->next = temp;
            slow = temp;
        }

    }
    ListNode* reverse(ListNode *head) {
        // null
        if(head == NULL || head->next == NULL) return head;
        ListNode *prev = NULL, *curr = head, *fast = head->next;
        while(fast != NULL) {
            curr->next = prev;
            prev = curr;
            curr = fast;
            fast = fast->next;
        }
        curr->next = prev;
        return curr;
    }
};