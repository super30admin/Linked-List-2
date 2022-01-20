//Time Complexity - O(n)
//Space Complexity - O(1)

//Problem successfully compiled on leet code
//No problems faced while coding this.


#include<iostream>
using namespace std;


  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int lenA=0;
        int lenB=0;
        
        ListNode* A=headA;
        ListNode* B=headB;
        while(A!=NULL)
        {
            A=A->next;
            lenA++;
        }
        while(B!=NULL)
        {
            B=B->next;
            lenB++;
        }
        A=headA;
        B=headB;
        if(lenA>lenB)
        {
            int timesToGoFront=lenA-lenB;
            
            while(timesToGoFront>0)
            {
                A=A->next;
                timesToGoFront--;
            }
        }
        else if(lenB>lenA)
        {
            int timesToGoFront=lenB-lenA;
            while(timesToGoFront>0)
            {
                B=B->next;
                timesToGoFront--;
            }
        }
        
        
        while(A!=NULL)
        {
            if(A==B)
            {
                return A;
            }
            A=A->next;
            B=B->next;
        }
        
        return NULL;
        
    }
};