//Time complexity - O(n)
//Space complexity - O(1)

class Solution {
public:
    ListNode* reverse(ListNode* head){
        ListNode* prev = NULL,*n = head, *node = head;
        
        while(n!=NULL){
            n = node->next;
            node->next = prev;
            prev = node;
            node = n;
        }
        
        return prev;
        
    }
    void reorderList(ListNode* head) {
        
        if(head == NULL || head->next == NULL) return;
        ListNode* s = head, *f = head, *retHead = head;
        
        while(f->next && f->next->next){
            f = f->next->next;
            s = s->next;
        }
        
        ListNode* ll1 = head;
        ListNode* ll2 = reverse(s);
        ListNode* ll1Next,*ll2Next;
        
        while(ll1 && ll2){
            ll1Next = ll1->next; 
            ll1->next = ll2;
            ll2Next = ll2->next;
            ll1 = ll1->next;
            ll1->next = ll1Next;
            ll1 = ll1->next;
            ll2 = ll2Next;
        }
        return;
        
    }
};