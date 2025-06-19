//Time Complexity :O(n)
//Space Complexity:O(1)
#include<iostream>
#include<vector>
using namespace std;
struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };
class Solution {
public:
ListNode* reverse(ListNode* head){
        ListNode* prev = nullptr;
        ListNode* curr = head;
        while(curr != nullptr){
            ListNode* ptr = curr->next;
            curr->next = prev;
            prev = curr;
            curr = ptr;
        }

        return prev;
    }
    void reorderList(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast->next != nullptr && fast->next->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode* rh = reverse(slow->next);
        slow->next = nullptr;
        fast = rh;
        slow = head;
        while(fast != nullptr){
            ListNode* ptr = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = ptr;
            slow = ptr;
        }
    }
};