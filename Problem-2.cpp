


143. Reorder List

TC O(n)
SC O(1)


class Solution {
public:

    // Reverse a List and return head of it
    ListNode* reverse(ListNode* &prev, ListNode* &curr){
        if(curr == NULL)
            return prev;
        ListNode* forward = curr -> next;
        curr -> next = prev;
        return reverse(curr, forward);
    }


    // Find a middle node of an element;
    ListNode* findMid(ListNode* &head){

        ListNode* slow = head;
        ListNode* fast = head -> next;

        while(fast && fast->next){
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        return slow;
    }


    void reorderList(ListNode* head) {
        
        //Base condition
        if(!head || !head->next )
            return;

        //firstList
        ListNode* firstList = head;

        //middle element
        ListNode* mid = findMid(head);

        //secondList
        ListNode* secondList = mid->next;
        mid->next = NULL;
        
        //reverse second list
        ListNode* prev = NULL;
        secondList = reverse(prev, secondList);

        ListNode* ans = new ListNode(-1);
        ListNode* temp = ans;
            

        while(firstList != NULL){

            temp -> next = firstList;
            temp = firstList;
            firstList = firstList -> next;
            
            if(secondList != NULL){
                temp -> next = secondList;
                temp = secondList;
                secondList = secondList -> next;
            }
        }

        head = ans -> next;
    }
};


