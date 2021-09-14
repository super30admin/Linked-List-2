// Time Complexity : O(n+m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
         if(headA == NULL || headB==NULL ) return NULL;  // edge case
        int lengthA = 0 , lengthB = 0;
        ListNode* tempA = headA;
        ListNode* tempB = headB;
        while(headA!=NULL){
                headA = headA->next;
                lengthA++;  // get the length of first linkedlist
            }
         while(headB!=NULL){
                headB = headB->next;
                lengthB++;  // get the length of second linkedlist
            }
        if(lengthA<lengthB){
            int n= lengthB-lengthA;  // if one of the lengths is larger than other bring it to same level
            while(n){
                tempB = tempB->next;
                n--;
            }
        }
         if(lengthB<lengthA){
            int n= lengthA-lengthB;   // same as above
            while(n){
                tempA = tempA->next;
                n--;
            }    
        }
        while(tempA!=NULL){
            if(tempA == tempB) return tempA;  // check for the checkpoint
            tempA = tempA->next;
            tempB = tempB->next;
        }
        
        
        
        return NULL;
        
        
        
        
        
        
        
        /*set<ListNode*> s;
        if(headA == NULL || headB==NULL ) return NULL;
        while(headA !=NULL || headB !=NULL){
            if(headA!= NULL){
                if(s.find(headA) != s.end()){
                    return headA;
                }

                s.insert(headA);
                headA = headA->next;
            }
            if(headB!=NULL){
                if(s.find(headB) != s.end()){
                    return headB;
                }
                s.insert(headB);
                headB = headB->next;
            }
        }
        return NULL;
        */
    }
};

// int main(){
    
//     return 0;
// }