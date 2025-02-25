#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


ListNode* reverse(ListNode* head){
    ListNode* revHead = head;
    while(head->next){
        ListNode* temp = head->next;
        head->next = head->next->next;
        temp->next = revHead;
        revHead = temp;
    }
    return revHead;
}
void reorderList(ListNode* head) {
    if(!head||!head->next) return;
    ListNode* fast = head->next, *slow = head;
    while(fast&&fast->next){
        slow = slow->next;
        fast = fast->next->next;
    }

    ListNode* reversed = reverse(slow->next);
    slow->next = NULL;
    ListNode* ptr1 = head, *ptr2 = reversed;
    while(ptr2){
        ListNode* temp = ptr1->next;
        ptr1->next = ptr2;
        ListNode* temp2 = ptr2->next;
        ptr2->next = temp;
        ptr1 = temp;
        ptr2 = temp2;
    }
}

int main(){
    ListNode* head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(4);
    head->next->next->next->next = new ListNode(5);
    reorderList(head);
    while(head){
        cout<<head->val<<" ";
        head = head->next;
    }
    return 0;
}
// Time Complexity: O(n)
// Space Complexity: O(1)
// Input: 1->2->3->4->5
// Output: 1->5->2->4->3
// Explanation: The linked list is reordered.