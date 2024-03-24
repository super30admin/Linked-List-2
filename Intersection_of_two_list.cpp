// Time Complexity : O(2n) == O(n)    
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/intersection-of-two-linked-lists/description/

Given the heads of two singly linked-lists headA and headB, 
return the node at which the two lists intersect. 
If the two linked lists have no intersection at all, return null.
For example, the following two linked lists begin to intersect at node c1:
*/

/*
Explaination : 
First, size of both linked list is measured.
Then diff is counted.
Longer list is traversed for diff time. After this, both lists will be of same size.
Then both lists are traversed and intersection is found.
*/

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        
        int countA = 0;
        int countB = 0;

        ListNode* ptrA = headA;
        while(ptrA != nullptr){
            ptrA = ptrA->next;
            countA++;
        }
        ListNode* ptrB = headB;
        while(ptrB != nullptr){
            ptrB = ptrB->next;
            countB++;
        }

        ptrA = headA;
        ptrB = headB;
        int diff = std::abs(countA - countB);
        if(countA > countB){
            while(diff > 0){
                ptrA = ptrA->next;
                diff--;
            } 
        } else {
            while(diff > 0){
                ptrB = ptrB->next;
                diff--;
            }
        }

        while(ptrA != nullptr){
            if(ptrA == ptrB){
                break;
            }
            ptrA = ptrA->next;
            ptrB = ptrB->next;
        }
        return ptrA;
    }
};