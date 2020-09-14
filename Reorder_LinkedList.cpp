// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

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
        vector<int> store;
        ListNode* curr = head;
        ListNode* re = new ListNode();
        while(curr){
            store.push_back(curr->val);
            curr = curr->next;
        }
        int x = 0;
        int y = store.size()-1;
        ListNode* res = new ListNode();
        ListNode* rs = res;
        while(x<y && res){
            //cout<<store[x]<<" "<<store[y]<<endl;
            res->next = new ListNode(store[x]);
            res = res->next;
            res->next = new ListNode(store[y]);
            res = res->next;
            //cout<<rs->val<<" ";
            x++;
            y--;
        }
        if(x==y) {res->next = new ListNode(store[x]);}
        // while(rs){
        //     cout<<rs->val<<" ";
        //     rs = rs->next;
        // }
        if(rs && rs->next && rs->next->next)
            head->next = rs->next->next;
      //  return res->next;
    }
};