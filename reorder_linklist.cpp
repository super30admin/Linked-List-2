//Time O(n)
 //Space O(1)
 //Leetcode = Yes
 //Issue seen: none
class Solution {
public:
    ListNode* reverse(ListNode* head){
        ListNode* prev = NULL;
        ListNode* curr = head;
        while(curr){
            ListNode* temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    void reorderList(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        
        //Find middle
        while(fast->next && fast->next->next){
            slow = slow->next;
            fast = fast->next->next;
        }

        //reverse last half
        fast = slow->next;
        slow->next = NULL;
        fast = reverse(fast);
        slow = head;
        //Merge the lists
        while(fast && slow){
            ListNode* temp = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = temp;
            slow = slow->next->next;
            
         }

    }
};
