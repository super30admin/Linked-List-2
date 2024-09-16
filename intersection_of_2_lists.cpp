//Time Complexity-O(n)
//Space Complexity-O(1)
//Ran successfully on leetcode
//3 point algo-
//1.Get size of the two lists. Find the difference of their sizes.
//2.Move the start pointer of the larger list till the difference.
//3.Then traverse through the lists at the same time till you reach the same node.

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode*A=headA;
        ListNode*B=headB;
        int n1=0,n2=0; //Size of the two linked lists
        while(A!=NULL)
        {
            A=A->next;
            n1++;
        }
        while(B!=NULL)
        {
            B=B->next;
            n2++;
        }
        A=headA;
        B=headB;
        if(n1>n2)
        {
            int diff=n1-n2;
            int i=0;
            while(i<diff)
            {
                A=A->next;
                i++;
            }
        }
        else
        {
            int diff=n2-n1;
            int i=0;
            while(i<diff)
            {
                B=B->next;
                i++;
            }
        }
        while(A!=B)
        {
            A=A->next;
            B=B->next;
        }
        return A;
    }
};