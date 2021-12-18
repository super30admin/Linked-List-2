/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

//Time complexity : O(m + n) // where m is length of 1st list and n is the length of 2nd list
//Space complexity : O(1)

//Leetcode : Yes
//Approach :
            // Find length of both the lists
            // Find the difference between both the lengths
            // Whichever has greater length, increment the headpointer till difference is same
            // Once the length is same, start incrementing both the pointers equally
            // Once both the pointers are equal, return any one of the pointer

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if(headA == nullptr || headB == nullptr)
        {
            return nullptr;
        }
        
        int l1 = 0;
        int l2 = 0;
        ListNode* ptr = headA;
        while(ptr != nullptr)
        {
            ptr = ptr->next;
            l1++;
        }
        ptr = headB;
        while(ptr != nullptr)
        {
            ptr = ptr->next;
            l2++;
        }
        
       while(l1 > l2)
       {
           headA = headA->next;
           l1--;
       }
       while(l2 > l1)
       {
           headB = headB->next;
           l2--;
       }
        
       while(headA != headB)
       {
           headA = headA->next;
           headB = headB->next;
       }
        
       return headA;
    }
};