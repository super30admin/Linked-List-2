//Time Complexity:O(m+n)
//Space Complexity :O(1)
#include<iostream>
#include<vector>
using namespace std;
struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
class Solution {
public:
    int length(ListNode * head)
    {  int count = 0;
        while(head != NULL)
        {
            count++;
            head = head -> next;
        }
        return count;
    }
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int len_a = length(headA);
        int len_b = length(headB);
        int n;
        if(len_a > len_b)
        {
            n = len_a - len_b;
            while(n>0)
            {
                headA = headA -> next;
                n--;
            }
        }
        else
        {
            n = len_b - len_a;
            while(n>0)
            {
                headB = headB -> next;
                n--;
            }
        }

        while(headA != NULL && headB != NULL)
        {
            if(headA  == headB )
            {
                break;
            }
            headA = headA -> next;
            headB = headB -> next;
        
        }
        return headA;

    }
};