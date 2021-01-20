
// Time Complexity : O(n) where n is number of elements
// Space Complexity : O(1) we are not using extra space
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


#include<vector>
#include<bits/stdc++.h>
#include<stdlib.h>
#include<cmath>
#include<time.h>
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
        
        if(head == NULL || head->next == NULL) return;
        
        ListNode* slow=head;
        ListNode* fast=head;
        
        while(fast->next != NULL && fast->next->next != NULL){
            slow=slow->next;
            fast=fast->next->next;
        }
        
        fast=reverse(slow->next);
        slow->next=NULL;
        
        slow = head;
        ListNode* temp;
        
        while(fast != NULL){
            temp=slow->next;
            slow->next=fast;
            fast=fast->next;
            slow->next->next=temp;
            slow=temp;
            
        }
        
        
        
    }
private:
    ListNode* reverse(ListNode* reverse){
        ListNode* prev=NULL;
        ListNode* curr=reverse;
        ListNode* fast=curr->next;
        
        while(fast!=NULL){
            curr->next=prev;
            prev=curr;
            curr=fast;
            fast=fast->next;
        }
        
        curr->next = prev;
        
        return curr;
        
    }
    
};







int main(){

    


    Solution a;

    ListNode* head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(4);
    // head->next->next->next->next = newNode(5);

    // vector<int>  nums={0,0,1,1,1,1,2,3,3};
    //int target=5;
    a.reorderList(head);
    // for (int x : nums) 
    //      cout << x << " "; 

    // cout<<endl;

    while(head!=NULL){
        cout<<head->val<<" ";
        if (head->next)
            cout << "-> ";
        head=head->next;
    }

    // can either do this below for answer in true false 
    // cout.setf(std::ios::boolalpha);
    // cout <<  b << endl;

    // or

    // cout <<  boolalpha << b << endl;

}