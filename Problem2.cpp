// Time Complexity : O(N) N is nodes in LL
// Space Complexity : O(1)   
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Find mid pointer using hair and tortoise method than reverse second half of LL while storing mid pointer.
// 2. Traverse from head to mid again while inserting elements of second LL(reversed second half) 
// between current and current->next element till mid.

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
        ListNode* slow=head;
        ListNode* fast=head;
        ListNode* h1=head;
        while( ((fast != nullptr)) && (fast->next != nullptr) ){
            slow=(slow->next);
            fast=(fast->next->next);
        }
        ListNode* t=(slow->next);
        //cout<< slow->val << '\n';
        if(t!=nullptr){
            slow->next = nullptr;
        }
        ListNode* prev=nullptr;
        while(t!=nullptr){
            ListNode* tt=t->next;
            t->next = prev;
            prev = t;
            t=tt;
        }
        bool f=0;
        //cout<< prev->val << '\n';
        while(prev!=nullptr && h1!=nullptr){
            if(f==0){
                ListNode* tt=h1->next;
                h1->next = prev;
                h1=tt; f=!f;
            }else{
                ListNode* tt=prev->next;
                prev->next = h1;
                prev=tt; f=!f;
            }
        }

    }
};