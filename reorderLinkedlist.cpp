/**
 * TC - O(n)
 * SC - O(1)
 */
class Solution {
public:
    void reorderList(ListNode* head) {
         ListNode* slowPointer = head;
         ListNode* fastPointer = head;
         while(fastPointer->next && fastPointer ->next->next){
             slowPointer = slowPointer->next;
             fastPointer = fastPointer ->next ->next;
         }
         fastPointer = slowPointer;
         slowPointer = reverseLinkedList(slowPointer->next);
         fastPointer->next = NULL;

         fastPointer = head;
         ListNode* temp1;
         ListNode* temp2;
         while(slowPointer){
             temp1 = fastPointer->next;
             temp2 = slowPointer->next;
             fastPointer->next =slowPointer;
             fastPointer->next->next = temp1;
             fastPointer = temp1;
             slowPointer = temp2;
         }
    }
    ListNode* reverseLinkedList(ListNode* head){
        ListNode* prev = nullptr;
        ListNode* curr = head;
        ListNode* temp;
            while(curr){
                temp = curr->next;// store next address
                curr->next = prev;// reverse link
                prev = curr; // track prev list
                curr = temp;// go to next pointer
            }
            return prev;
    }
};