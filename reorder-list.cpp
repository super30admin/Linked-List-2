/*Find the middle of the linked list using slow and fast pointers.
Reverse the second half of the linked list.
Merge the first and reversed second halves by alternating nodes.
Time Complexity: O(N), where N is the number of nodes in the linked list. The algorithm iterates through the list twice: once to find the middle and once to reorder.
Space Complexity: O(1), as the reordering is done in-place without using any additional data structures.*/
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
        if(head==NULL)return;
        ListNode* slow=head, *fast=head;
        while(fast&&fast->next){
            slow=slow->next;
            fast=fast->next->next;
        }
        ListNode* prev=NULL,*curr=slow,*temp=NULL;
        while(curr){
            temp=curr->next;
            curr->next=prev;
            prev=curr;
            curr=temp;
        }
        ListNode* first=head,*second=prev;
        while(second->next){
            temp=first->next;
            first->next=second;
            first=temp;

            temp=second->next;
            second->next=first;
            second=temp;
        }
    }
};