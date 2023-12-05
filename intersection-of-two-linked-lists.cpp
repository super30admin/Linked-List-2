/*
Initialize two pointers (a and b) at the heads of the linked lists. 
Traverse both lists simultaneously, resetting pointers to the other list's head when they reach the end.
If there is an intersection, the pointers will meet at the intersection node; otherwise, they will reach the end of both lists. Return the intersection node if found or nullptr if no intersection.
Time Complexity: O(M + N), where M and N are the lengths of the two linked lists.
Space Complexity: O(1), as it uses a constant amount of extra space regardless of the input size.*/
#include<bits/stdc++.h>
using namespace std;
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
        if(!headA ||!headB)return nullptr;
        ListNode *a=headA;
        ListNode *b=headB;
        while(a!=b){
            a=(a)?a->next:headB;
            b=(b)?b->next:headA;
            if(a==b)return a;
        }
        return a;
    }
};