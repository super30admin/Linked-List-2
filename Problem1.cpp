//
// Created by shazm on 7/25/2019.
//

#include <iostream>
#include <algorithm>
#include <bits/stl_vector.h>

// Runtime: O(n)
// Space: O(n)
// Approach: Add all elements in the LinkedList to a vector. After adding to vector, traverse through the vector and if
// the index is even, add from the beginning else add from the end.

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    void reorderList(ListNode* head) {
        vector<int> ListVec;
        ListNode* temp = head;
        while(temp!=NULL){
            ListVec.push_back(temp->val);
            temp = temp->next;
        }
        temp = head;
        int count = 0;
        for(int x = 0; x<ListVec.size(); x++){
            if(x%2==0){
                temp->val = ListVec[count];
                count++;
            }else{
                temp->val = ListVec[ListVec.size()-count];
            }
            temp = temp->next;
        }
    }
    void reorderListOptimized(ListNode* head) { //Optimized. Runtime: O(N). Space: O(1)
        if(head==NULL || head->next==NULL){
            return;
        }
        ListNode* slow = head;
        ListNode* fast = head->next;
        while(fast!=NULL && fast->next!= NULL){
            slow = slow->next;
            fast = fast->next->next;
        }

        fast = reverseLinkedList(slow->next);
        slow->next = NULL;
        slow = head;
        ListNode* fasttemp; ListNode* slowtemp;
        while(slow!=NULL&&fast!=NULL){
            slowtemp = slow->next;
            fasttemp = fast->next;
            slow->next = fast;
            fast->next = slowtemp;
            fast = fasttemp;
            slow = slowtemp;
        }
    }
private:
    ListNode* reverseLinkedList(ListNode* head){
        ListNode* prev = NULL;
        ListNode* curr = head;
        while(curr!=NULL){
            ListNode* next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
};

int main(){
    Solution s;
    return 0;
}