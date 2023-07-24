// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
This problem is divided into three sub problems, the first being finding the middle,
after finding the middle, we then reverse the linked list starting from node after the middle.
Then we remove the connection between the 2 linked lists and start connecting it. we connect the first element from the first linked list
to the first element of the second list and increment the pointers until they reach null.



*/


// Your code here along with comments explaining your approach
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:

    ListNode* reversed(ListNode* head){
        ListNode* prev = NULL;
        ListNode* curr = head;
        ListNode* temp1 = curr->next;

        while(temp1 != NULL){
            curr->next = prev;
            prev = curr;
            curr= temp1;
            temp1=temp1->next;
        }

        curr->next=prev;
        return curr;

        

    }
    void reorderList(ListNode* head) {

        if(head==NULL || head->next==NULL|| head->next->next==NULL){
            return;
        }

        ListNode* slow = head;
        ListNode* fast = head;

        while(fast->next!=NULL && fast->next->next != NULL){
            fast= fast->next->next;
            slow = slow->next;

        }

        fast = reversed(slow->next);
        slow->next=NULL;

        slow = head;
        

        

        while(fast!=NULL){
            ListNode* temp = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = temp;
            slow = temp;

        }




        
    }
};