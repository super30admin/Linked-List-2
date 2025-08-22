#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
/*
First we find the middle of the list using two pointers.
Then we reverse the second half of the list.
Finally, we merge the two halves in a zig-zag manner.
*/
class Solution{
private:
    ListNode* reverse(ListNode* head){
        ListNode* prev = nullptr;
        ListNode* curr = head;

        while(curr != nullptr){
            ListNode* temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
public:
    void reorderList(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;

        while(fast->next != nullptr && fast->next->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
        }

        ListNode* reversedHead = reverse(slow->next);
        slow->next = nullptr;

        fast = reversedHead;
        slow = head;

        while(fast != nullptr){
            ListNode* temp = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = temp;
            slow = temp;
        }
    }
    
};
