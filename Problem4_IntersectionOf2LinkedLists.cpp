
// Time Complexity : O(m)+O(n) where n is number of elements of 1 linked list and m for other
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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        
        int lenA = 0; // length of 1st path
        int lenB = 0; // length of second path
        int diff; // difference between the lengths
        
        ListNode* A=headA;
        ListNode* B=headB;
        
        while(A!=NULL){ // calc of length
            lenA+=1;
            A=A->next;
        }
        
        while(B!=NULL){  // calc of length 
            lenB+=1;
            B=B->next;
        }
        
        while(lenA > lenB){
            
            headA=headA->next;
            lenA--;
        }
        
        while(lenB>lenA){
            headB=headB->next;
            lenB--;
        }
            
            
        
        
//         if(lenA > lenB){
//             diff=lenA-lenB;
//             while(diff != 0){
//                 headA = headA->next;
//                 diff--;
//             }
//         }else{
//             diff = lenB-lenA;
//             while(diff > 0){
//                 headB = headB->next;
//                 diff--;
//             }
            
//         }
        
        while(headA != headB){
            headA = headA->next;
            headB = headB->next;
        }
        
        return headA;  
        
    }
};




int main(){

    


    Solution a;

        ListNode* newNode;
 
    // Addition of new nodes
    ListNode* head1 = new ListNode();
    head1->val = 10;
 
    ListNode* head2 = new ListNode();
    head2->val = 3;
 
    newNode = new ListNode();
    newNode->val = 6;
    head2->next = newNode;
 
    newNode = new ListNode();
    newNode->val = 9;
    head2->next->next = newNode;
 
    newNode = new ListNode();
    newNode->val = 15;
    head1->next = newNode;
    head2->next->next->next = newNode;
 
    newNode = new ListNode();
    newNode->val = 30;
    head1->next->next = newNode;
 
    head1->next->next->next = NULL;





    // ListNode* head = new ListNode(1);
    // head->next = new ListNode(2);
    // head->next->next = new ListNode(3);
    // head->next->next->next = new ListNode(4);
    // head->next->next->next->next = new ListNode(5);

    // ListNode* headB = new ListNode(6);
    // headB->next = new ListNode(7);
    // headB->next->next = new ListNode(4);
    // headB->next->next->next = new ListNode(11);
    // headB->next->next->next->next = new ListNode(12);

    // // vector<int>  nums={0,0,1,1,1,1,2,3,3};
    // //int target=5;
    ListNode* r= a.getIntersectionNode(head1->next,head2->next);
    // for (int x : nums) 
    //      cout << x << " "; 

    // cout<<endl;
    cout<<r->val<<endl;

    // while(head!=NULL){
    //     cout<<head->val<<" ";
    //     if (head->next)
    //         cout << "-> ";
    //     head=head->next;
    // }

    // can either do this below for answer in true false 
    // cout.setf(std::ios::boolalpha);
    // cout <<  b << endl;

    // or

    // cout <<  boolalpha << b << endl;

}