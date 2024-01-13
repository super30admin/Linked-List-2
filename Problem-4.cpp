// Time Complexity : O(N) 

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes

// Appoarch: Using two dummy nodes temp1 and temp2 iterated the two lists until
// we reach null and then interchanged temp1 and temp2 to get both aligned until 
// they become equal.

// 160

#include<bits/stdc++.h>
using namespace std;
 
 // Definition for singly-linked list.
  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if(headA == NULL || headB == NULL) return NULL;
        ListNode* temp1 = headA;
        ListNode* temp2 = headB;
        while(temp1 != temp2){
            temp1 = temp1->next;
            temp2 = temp2->next;
            if(temp1 == temp2){
                return temp1;
            }
            if(temp1 == NULL){
                temp1 = headB;
            }
            if(temp2 == NULL){
                temp2 = headA;
            }
        }
        return temp1;
    }
};