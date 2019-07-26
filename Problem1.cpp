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
};

int main(){
    Solution s;
    return 0;
}