//
// Created by shazm on 7/26/2019.
//

#include <iostream>
#include <algorithm>

// Runtime: O(n)
// Space: O(1)
// Approach: count headA and count headB. if headA>headB then bring headA to the same position as headB and do vice-versa
// if headB count is greater. then traverse till headA and headB not equal to null. If during traversing headA==headB then
// return headA or headB.

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if(headA == NULL || headB == NULL){return NULL;}
        int countA = 0;
        int countB = 0;
        ListNode* tempA = headA;
        ListNode* tempB = headB;
        while(tempA!=NULL){
            countA++;
            tempA = tempA->next;
        }
        while(tempB!=NULL){
            countB++;
            tempB = tempB->next;
        }
        tempA = headA; tempB = headB;
        if(countA>countB){
            while(countA!=countB){
                tempA = tempA->next;
                countA--;
            }
        }else if(countB>countA){
            while(countB!=countA){
                tempB = tempB->next;
                countB--;
            }
        }

        while(tempA!=NULL && tempB!=NULL){
            if(tempA==tempB){
                return tempA;
            }
            tempA = tempA->next;
            tempB = tempB->next;
        }
        return NULL;
    }
};

int main(){
    Solution s;

    return 0;
}