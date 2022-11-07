/*
Time Complexity: O(m+n)(To go through both the linked list.) 
Space Complexity: O(1)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
*/

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
    int sizeOfNodes(ListNode* node){
        int size=0;
        while(node!=NULL){
            size++;
            node=node->next;
        }
        return size;
    }
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int sizeA = sizeOfNodes(headA);
        int sizeB = sizeOfNodes(headB);
        
        if(sizeA<sizeB){
            int temp = sizeB;
            sizeB = sizeA;
            sizeA = temp;
            
            ListNode *temp1 = headB;
            headB = headA;
            headA = temp1;
        }
        int diff = sizeA - sizeB;
        
        while(diff>0){
            diff--;
            headA=headA->next;
        }
        cout<<headB->val;
        while(headA != NULL && headA!=headB){
            headA = headA->next;
            headB = headB->next;
        }
        return headA;
    }
};