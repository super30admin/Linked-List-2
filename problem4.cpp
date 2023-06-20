/*

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
End case when they dont merge.


// Your code here along with comments explaining your approach
Traverse both the linked list and count their length.
Then move the larger list by the difference between the length between the two list
Then tarverse both the pointers until they meet.

*/



#include<iostream>
#include<vector>

using namespace std;

typedef struct ListNode{
    int val;
    ListNode* next;
    ListNode(int x):val(x),next(nullptr){}

}ListNode;

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int cnt_a{};
        ListNode* temp;
        for(temp = headA;temp!=NULL;temp=temp->next) cnt_a++;
        int cnt_b{};
        for(temp = headB;temp!=NULL;temp=temp->next) cnt_b++;
        while(cnt_a>cnt_b){
            headA = headA->next;
            cnt_a--;
        }
        while(cnt_b>cnt_a){
            headB = headB->next;
            cnt_b--;
        }
        while(headA && headB && headA != headB){
            headA = headA->next;
            headB = headB->next;
        }
        return headA;
    }
};