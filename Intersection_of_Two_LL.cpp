/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
    int Length_Calculator(ListNode* node){
        int length=0;
        while(node!=NULL){
            node = node->next;
            length++;
        }
        return length;
    }
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int l1=Length_Calculator(headA);
        int l2=Length_Calculator(headB);
        int d;
        ListNode*ptr1;
        ListNode*ptr2;

        if(l1>l2){
            d = l1-l2;
            ptr1 = headA;
            ptr2 = headB;
        }
        else{
            d= l2-l1;
            ptr1=headB;
            ptr2=headA;
        }
        while(d--){
            ptr1 = ptr1->next;
            if(ptr1==NULL)return NULL;
        }
        while(ptr1!=NULL && ptr2!=NULL){
            if(ptr1==ptr2) return ptr1;
            ptr1=ptr1->next;
            ptr2=ptr2->next;
        }
return NULL;        
    }
};
