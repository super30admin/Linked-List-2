//Time Complexity - O(m+n)
//Space Complexity - O(1)
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if(headA==NULL||headB==NULL)
            return NULL;
        int n1=0,n2=0;
        ListNode* temp=headA;
        while(temp!=NULL){
            temp=temp->next;
            n1++;
        }
        temp=headB;
        while(temp!=NULL){
            temp=temp->next;
            n2++;
        }
        while(n1>n2){
            headA=headA->next;
            n1--;
        }
        while(n2>n1){
            headB=headB->next;
            n2--;
        }
        while(headA!=headB){
            headA=headA->next;
            headB=headB->next;
        }
        return headB;
    }
};