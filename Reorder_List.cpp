//
//  main.cpp
//  143_Reorder_List


#include <iostream>
using namespace std;

class ListNode {
public:
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};



/*  Using two point approach, find the mid element and reverse the second half of
    list.
    TC:O(N), SC:O(1).
*/
class Solution {
public:
    
    void reorderList(ListNode* head) {
        if(head == NULL) return;
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast != NULL && fast->next != NULL){
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        //cout<<slow->val;

        ListNode* mid = reverseList(slow);
        slow = head;
        while(slow != NULL && mid != NULL && mid->next != NULL){
            ListNode* temp = slow->next; //temp
            ListNode* temp1 = mid->next; //temp
            slow->next = mid;
            mid->next = temp;
            mid = temp1;
            slow=slow->next->next;
            
        }
        
    }
    //reverse second half of list
    ListNode* reverseList(ListNode* head) {
        if(head == NULL)
            return NULL;
        ListNode* curr  = head;
        while(curr->next!=NULL){
            ListNode* temp = curr->next;
            curr->next = curr->next->next;
            temp->next = head;
            head = temp;
        }
        return head;
    }
};


int main(int argc, const char * argv[]) {
    ListNode* temp = new ListNode(1);
    ListNode* head  = temp;
    for(int i=2;i<=5;i++){
        ListNode* node1  = new ListNode(i);
        temp->next = node1;
        temp =temp->next;
    }
    Solution s;
    s.reorderList(head);
    while(head!=NULL){
        cout<<head->val<<endl;
        head=head->next;
    }
    return 0;
}
