// Time Complexity: O(n)
// Space Complexity: O(1) for the pointers used in the algorithm
// Were you able to solve the problem on Leetcode?: Yes
// Did you face any challenges while solving the problem? No

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
    void reorderList(ListNode* head) {
        ListNode* slow;
        ListNode* fast;

        slow = head;
        fast=head;

        // find the middle of the list using slow and fast pointers
        while(fast->next != nullptr && fast->next->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
        }

        // reverse the second half of the list in place
        ListNode* reversed = reverse(slow->next);

        // seperate the two halves of the list
        slow->next = nullptr;

        // reassign fast to reversed head (second half) and slow to original head (first half)
        fast = reversed;
        slow = head;

        // start to merge the two halves in an alternate manner
        while(fast != nullptr){
            // store temp to preserve next of slow
            ListNode* temp = slow->next;
            // assign the element from second half as the next element of the current first half element
            slow->next = fast;
            // move fast to next element of 2nd half
            fast = fast->next;
            // assign the next element as the first half next stored in temp
            slow->next->next = temp;
            // move slow to next element of 1st half
            slow = temp;
        }


    }
private:
    ListNode* reverse(ListNode* node){

        
        // reverse the linked list in place
        // using three pointers: prev, curr, and temp
        ListNode* prev = nullptr;
        ListNode* curr = node;

        while(curr != nullptr){
            ListNode* temp = curr->next;

            curr->next = prev;
            prev = curr;
            curr = temp;

        }
        return prev;
    }

};