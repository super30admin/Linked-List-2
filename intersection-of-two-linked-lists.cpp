// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


#include <iostream>
  
using namespace std; 

struct ListNode{
        int data;
        ListNode *next;

        ListNode(int val){
            data = val;
            next = nullptr;
        }
};

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int asize = 0;
        ListNode *curr = headA;
        while(curr != nullptr){
            asize++;
            curr = curr->next;
        }
        int bsize = 0;
        curr = headB;
        while(curr != nullptr){
            bsize++;
            curr = curr->next;
        }
        while(asize > bsize){
            headA = headA->next;
            asize--;
        }
        while(bsize > asize){
            headB = headB->next;
            bsize--;
        }
        while(headA != headB){
            headA = headA->next;
            headB = headB->next;
        }
        return headA;
    }
};