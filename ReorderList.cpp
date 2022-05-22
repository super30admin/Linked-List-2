//TC = O(N)
//SC = O(1)
class Solution {
public:
    void reorderList(ListNode* head) {
        if(head!=NULL && head->next!=NULL){
            //Find Middle
            ListNode* middle = MiddleOfList(head);
            ListNode *secondList = middle->next;
            middle->next = NULL;
            //Reverse The second list
            ListNode *secondHead= reverseList(secondList);
            //Merge 
            mergeLists(head,secondHead);
        }
    }
    
    ListNode* MiddleOfList(ListNode *head){
        ListNode *slow = head;
        ListNode *fast = head;
        while(fast->next!=NULL && fast->next->next!=NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }
    
    ListNode *reverseList(ListNode *head){
        ListNode *prev = NULL;
        ListNode *curr = head;
        ListNode *nxt = head->next;
        while(curr->next!=NULL){
            curr->next = prev;
            prev = curr;
            curr = nxt;
            nxt = nxt->next;
        }
        curr->next = prev;
        return curr;
    }
    
    void mergeLists(ListNode* headA, ListNode *headB){
        ListNode* p1 = headA;
        ListNode* p2 = headB;
        ListNode *tempA, *tempB;
        while(p1!=NULL && p2!=NULL){
            tempA = p1->next;
            p1->next = p2;
            tempB = p2->next;
            p2->next = tempA;
            p1 = tempA;
            p2 = tempB;
        }
        if(p2!=NULL)
            p1->next = p2;
    }
};
