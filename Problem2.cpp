// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

#include<bits/stdc++.h>
using namespace std;
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
        if(head == NULL || head->next == NULL) return;
        // find the mid of the list
        ListNode* fast =  head->next;
        ListNode* slow = head;
        while(fast!=NULL && fast->next!=NULL){
            fast = fast->next->next;
            slow = slow->next;
        }
        // reverse the linkedlist from mid
        fast = reverseList(slow->next);  // reverse list from mid +1
        slow->next = NULL;  // cut the link
        slow = head;   // back to head

        // again fix  the links to get the reordered list
        while(fast!=NULL){
            ListNode* temp = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = temp;
            slow = temp;
        }
        
    }
    
    // function to reverse the linkedlist
    ListNode* reverseList(ListNode* head)
    {
        ListNode* prev = NULL;
        ListNode* curr = head;
        ListNode* fast = head->next;
        while(curr!=NULL){
            curr->next = prev;
            prev = curr;
            curr = fast;
            if(fast!=NULL) fast = fast->next;
        }
        return prev;
    }
};
// int main(){
    
//     return 0;
// }