
// Time Complexity : O(1) because we have only one element to delete
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


class Solution{
public: 
    void deleteNode(ListNode *node){
        node->val=node->next->val;
        node->next=node->next->next;// Your code here

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
    a.deleteNode(head->next);
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