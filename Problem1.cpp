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
   // class Solution {
    //public:
        void reorderListOptimized(ListNode* head) { //could not code the merging part. will do after class.
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
            int x =2;
            slow = head;
            // ListNode* prev = NULL;
            ListNode* temp = new ListNode(slow->val);
            ListNode* prev = temp;
            slow = slow->next;
            while(fast!=NULL&&slow!=NULL){
                if(x%2==0){
                    ListNode* node = new ListNode(fast->val);
                    node->next = new ListNode(prev->next->val);
                    prev->next = node;
                    fast = fast->next;
                }else{
                    ListNode* node = new ListNode(slow->val);
                    node->next = new ListNode(prev->next->val);
                    prev->next = node;
                    slow = slow->next;
                }
                x++;
            }

            // while(fast!=NULL && slow!= NULL){
            //     if(x%2==0){
            //         cout<<fast->val<<" fast "<<slow->val<<" slow"<<endl;
            //         temp = fast->next;
            //         prev->next = fast;
            //         fast->next = slow;
            //         fast = temp;
            //         prev = slow;
            //         if(fast==NULL){cout<<"woah\n";}
            //     }else{
            //         cout<<fast->val<<" fast "<<slow->val<<" slow"<<endl;
            //         prev = slow;
            //         slow = slow->next;
            //     }
            //     x++;
            // }
            *head = *temp;
            while(head!=NULL){
                cout<<head->val<<endl;
                head = head->next;
            }
            cout<<"outchi"<<endl;
        }

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
};

int main(){
    Solution s;
    return 0;
}