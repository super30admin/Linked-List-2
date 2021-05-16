/*
Time complexity - O(N)
Space complexity - O(1)
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
    void reorderList(ListNode* head) {
        if (!head) return;
        ListNode *slow = head, *fast = head;
        while (fast->next && fast->next->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        //slow at the middle
        //Reverse second half of LL
        fast = reverse(slow->next);
        slow = head;
        //Merge two LL
        ListNode *curr;
        while (fast){
            curr = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = curr;
            slow = curr;
        }
        slow->next = NULL;
    }
    
private:
    ListNode* reverse(ListNode* head){
        if (!head) return NULL;
        ListNode *prev = NULL, *curr = head, *fast = head->next;
        while (fast){
            curr->next = prev;
            prev = curr;
            curr = fast;
            fast = fast->next;
        }
        curr->next = prev;
        return curr;
    }
};