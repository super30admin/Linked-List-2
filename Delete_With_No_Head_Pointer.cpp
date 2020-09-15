//
//  main.cpp
//  Delete_With_No_Head_Pointer

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

/* copy the next node value to node to be deleted and update the node->next pointer
   to node->next->next.
    TC:O(1), SC:O(1)
 */
class Solution{
public:
    void deleteNode(ListNode* node){
        node->val = node->next->val;
        node->next = node->next->next;
    }
};


int main() {
    ListNode* temp = new ListNode(1);
    ListNode* head  = temp;
    for(int i=2;i<=5;i++){
        ListNode* node1  = new ListNode(i);
        temp->next = node1;
        temp =temp->next;
    }
    Solution s;
    s.deleteNode(head->next->next->next);
    while(head!=NULL){
        cout<<head->val<<endl;
        head=head->next;
    }
    return 0;
}


