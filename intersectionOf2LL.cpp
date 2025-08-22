#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
/*
We take one pointer for list A and on for list B and then check if they
intersect, if they dont we return null 
*/
class Solution{
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* currA = headA;
        ListNode* currB = headB;

        while(currA != currB){
            currA = currA->next;
            currB = currB->next;

            if(currA ==nullptr && currB == nullptr) return nullptr;
            
            if(currA == nullptr) currA = headB;

            if(currB == nullptr) currB = headA;
        }
        return currA;
    }
};
