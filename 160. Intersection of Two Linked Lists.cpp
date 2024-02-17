/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

 /*
  Time: O(M+N)
  Space: O(1)

  Approach: Advance the head of the bigger list by the difference in their sizes, then move them simultaneously untill they meet or reach nullptr
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int n1 = 0, n2 = 0;
        auto h1 = headA, h2 = headB;
        
        //calculate lengths
        while(h1!=nullptr){
          n1++;
          h1=h1->next;
        }

        while(h2!=nullptr){
          n2++;
          h2=h2->next;
        }

        //make headA point to the bigger list
        if(n1<n2){
          swap(n1, n2);
          swap(headA, headB);
        }

        //advance headA (n1-n2) positions -> after that, headA and headB will have equal no. of nodes following
        while(n1>n2){
          headA = headA -> next;
          n1--;
        }

        //move two heads simultaneously until they meet or reach nullptr
        while(headA!=nullptr && headA!=headB){
          headA = headA->next;
          headB = headB->next;
        }

        //if they are not equal (never met), return nullptr
        return headA != nullptr && headA == headB ? headA : nullptr;
    }
};
