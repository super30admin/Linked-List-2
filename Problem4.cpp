// Time Complexity : O(N) N is nodes in LL
// Space Complexity : O(1)   
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach:
// 1. Traverse both given heads simulteneously till any one of head reaches last node.
// 2. If any head reaches last move it to head(first element) of other list. 
// 3. Perform until both traversing heads points same node as intersection will be that node.



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
        int c=0,c1=0;
        ListNode *tempA=headA;
        ListNode *tempB=headB;
        while(headA != headB){
            
            if( (headA) == nullptr ){
                if(c==1){
                    return nullptr;
                }
                headA=tempB;c++;
                continue;
            }
            if( (headB) == nullptr ){
                if(c1==1){
                    return nullptr;
                }
                headB=tempA;c1++;
                continue;
            }
            headA=(headA->next);headB=(headB->next);
        }
        return headA;
    }
};