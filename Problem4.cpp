
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Intersection of Two Linked Lists

#include<vector>
#include<iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
 };

#include<set>
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        
        if(headA == NULL || headB == NULL)
            return NULL;
            
        ListNode *ptr1 = headA;
        ListNode *ptr2 = headB;
        
        while(ptr1 != ptr2){    // whatever ptr encounters null first will end up traversing the extra distance and both the pointers will eventually be aligned and move together
            
            ptr1 = ptr1 == NULL ? headB : ptr1 = ptr1->next;
            ptr2 = ptr2 == NULL ? headA : ptr2 = ptr2->next;
        }
        
        return ptr1;        //Return any 1 or 2
    }
};