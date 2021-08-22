// Time Complexity : O(N) where N represents the no.of elements in the linkedlist
// Space Complexity : O(1) as we are not using any extra space for finding intersection
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/intersection-of-two-linked-lists/
// Submission Link: https://leetcode.com/submissions/detail/541158180/

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* temp1 = headA;
        int list1_size = 0;
        
        ListNode* temp2 = headB;
        int list2_size = 0;
        
        while(temp1 != NULL){
            temp1 = temp1 -> next;
            list1_size++;
        }
        
        while(temp2 != NULL){
            temp2 = temp2 -> next;
            list2_size++;
        }
        
        int diff;
        if(list1_size > list2_size){
            diff = list1_size - list2_size;
            
            while(diff > 0){
                headA = headA -> next;
                diff--;
            }
        }
        
        if(list2_size > list1_size){
            diff = list2_size - list1_size;
            
            while(diff > 0){
                headB = headB -> next;
                diff--;
            }
        }
        
        while(headA != NULL && headB != NULL){
            if(headA == headB)
                return headA;
            headA = headA -> next;
            headB = headB -> next;
        }
        
        return NULL;
    }
};