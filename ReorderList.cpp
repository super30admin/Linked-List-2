//Time Complexity - O(n)
//Space Complexity - O(1)

//Problem successfully compiled on leet code
//No problems faced while coding this.

#include<iostream>
using namespace std;

  struct ListNode {
     int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };

class Solution {
public:
    void reorderList(ListNode* head) {
        ListNode* fast=head->next;
        ListNode* slow=head;
        
        while(fast!=NULL && fast->next!=NULL)
        {
            slow=slow->next;
            fast=(fast->next)->next;
        }
        
        ListNode* prev=NULL;
        ListNode* current=slow->next;
        ListNode* next;
        slow->next=NULL;
        while(current!=NULL)
        {
            fast=current->next;
            current->next=prev;
            prev=current;
            current=fast;
        }
        
        ListNode* head2=prev;
        ListNode* ptr1=head;
        ListNode* ptr2=head2;
        ListNode* ptr1Next;
        ListNode* ptr2Next;
        
        while(ptr2!=NULL)
        {
            ptr1Next=ptr1->next;
            ptr2Next=ptr2->next;
            ptr1->next=ptr2;
            ptr2->next=ptr1Next;
            ptr2=ptr2Next;
            ptr1=ptr1Next;
        }  
        
    }
};