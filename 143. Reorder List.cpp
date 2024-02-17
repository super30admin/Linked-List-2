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

/*
Time: O(1)
Space: O(N) (Counting recursive stack space)

Approach: Recursively reach the end, then connect pairs untill meet-in-the-middle
*/

class Solution {
public:
    ListNode* lead;
    int n;
    int cnt;

    /*
    Although a tricky solution not gonna lie, the code is clean and easy to read
    */
    void call(ListNode* node){
      if(node==nullptr)  return;

      call(node->next);
      cnt++;
      
      //Food for thought:
      //  if this line is placed inside if condition, the last line (setting next to nullptr) has to be handled for both cnt = odd and cnt = even cases
      ListNode* leadNxt = lead->next;

      if(2 * cnt < n){
        lead->next = node;
        node->next = leadNxt;
        lead = leadNxt;
     }
    
     if(cnt==n/2)  leadNxt->next = nullptr;
    }

    void reorderList(ListNode* head) {
        cnt = n = 0;
        lead = head;

        ListNode* h = head;
        while(h!=nullptr){
          n++;
          h = h->next;
        }

        call(lead);
    }
};
