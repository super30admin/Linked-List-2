/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

//  TC ->O(N+M)
//  SC-> O(1)
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        //METHOD 1/////
        // unordered_map<ListNode*,bool>umap;
        // while(headA!=NULL){
        //     umap[headA] = true;
        //     headA = headA->next;
        // }
        // while(headB!=NULL){
        //     if (umap.find(headB)!=umap.end())return headB;
        //     headB = headB->next;
        // }
        // return NULL;
        
        //METHOD 2/////
        // ListNode* a_temp = headA;
        // ListNode* b_temp = headB;
        // int countA = 0;
        // int countB = 0;
        // while(a_temp!=NULL){
        //     countA++;
        //     a_temp = a_temp->next;
        // }
        // while(b_temp!=NULL){
        //     countB++;
        //     b_temp = b_temp->next;
        // }
        // if(countA>countB){
        //     int diff = countA-countB;
        //     while(diff!=0){
        //         diff--;
        //         headA = headA->next;
        //     }
        // }
        // if(countB>countA){
        //     int diff = countB - countA;
        //     while(diff!= 0){
        //         diff--;
        //         headB = headB->next;
        //     }
        // }
        // while(headA!=NULL && headB!=NULL){
        //     if(headA == headB)return headA;
        //     headA = headA->next;
        //     headB = headB->next;
        // }
        // return NULL;
        
        //METHOD 3
        ListNode* a = headA;
        ListNode* b = headB;
        while(a != b){
            if(a == NULL)a = headB;
            else a = a->next;
            if(b==NULL)b = headA;
            else b = b->next;
        }
        return a;
        
        
        
    }
};