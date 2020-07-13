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
        if(head==nullptr || head->next ==nullptr) return;
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast->next!= nullptr && fast->next->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
        }
        fast = slow->next;
        ListNode* prev = nullptr;
        slow->next = nullptr;
        while(fast!=nullptr){
            ListNode* next = fast->next;
            fast->next = prev;
            prev = fast;
            fast = next;
        }
        fast = prev;
        ListNode* next;
        while(head!=nullptr && fast!= nullptr){
            next = head->next;
            head->next = fast;
            fast = fast->next;
            head->next->next = next;
            head = next;
        }
    }
};