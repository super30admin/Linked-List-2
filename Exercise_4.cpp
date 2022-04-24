// Time Complexity                              :  O(max(M,N)), where M is the number of Nodes in list 1 and N is the number of Nodes in list 2.
// Space Complexity                             :  O(1)
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int headASize = 0;
        
        ListNode *tempA = headA;
        ListNode *tempB = headB;
        
        // get the count of number of nodes starting from headA node.
        int cA = 0, cB=0;
        while(tempA) {
            cA++;
            tempA = tempA->next;
        }
        
        // get the count of number of nodes starting from headB node.
        while(tempB) {
            cB++;
            tempB = tempB->next;
        }
        
        // Make the count equal by moving the head ahead if cA > cB
        while(cA > cB) {
            cA--;
            headA = headA->next;
        }
        
        // Make the count equal by moving the head ahead if cB > cA
        while(cB > cA) {
            cB--;
            headB = headB->next;
        }
        
        // Now both are equidistant from the Node of intersection of the two lists. 
        // Hence move them by 1 node at a time.
        while(headA and headB and headA != headB) {
            headA = headA->next;
            headB = headB->next;
        }
        
        return headA == NULL ? headB : headA;
        
    }
};