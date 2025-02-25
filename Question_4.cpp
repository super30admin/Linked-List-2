#include <bits/stdc++.h>
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
    ListNode* ptr = head;
    while(head->next){
        ListNode* temp = head->next;
        head->next = head->next->next;
        temp->next = ptr;
        ptr = temp;
    }
    return ptr;
}
ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
    int first_count = 0,second_count=0,third_count=0;
    ListNode* ptr = headA;
    while(ptr){
        first_count++;
        ptr = ptr->next;
    }
    ListNode* ptr2 = reverse(headA);
    ptr = headB;
    while(ptr->next){
        second_count++;
        ptr = ptr->next;
    }
    second_count++;
    if(ptr!=headA) {
        reverse(ptr2);
        return NULL;
    }
    reverse(ptr2);
    ptr = headB;
    while(ptr){
        third_count++;
        ptr = ptr->next;
    }
    int y = (third_count-first_count+second_count-1)/2;
    ptr = headB;
    int final_count = 0;
    while(final_count<y){
        final_count++;
        ptr = ptr->next;
    }        
    return ptr;
}

int main(){
    ListNode* headA = new ListNode(4);
    headA->next = new ListNode(1);
    headA->next->next = new ListNode(8);
    headA->next->next->next = new ListNode(4);
    headA->next->next->next->next = new ListNode(5);
    ListNode* headB = new ListNode(5);
    headB->next = new ListNode(0);
    headB->next->next = new ListNode(1);
    headB->next->next->next = headA->next->next;
    ListNode* intersection = getIntersectionNode(headA,headB);
    cout<<intersection->val;
    return 0;
}
// Time Complexity: O(n)
// Space Complexity: O(1)
// Input: headA = [4,1,8,4,5], headB = [5,0,1,8,4,5]
// Output: 8
// Explanation: The intersection node is 8.