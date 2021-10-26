/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 Time Complexity = O(N)
 Space Complexity = O(1)
 where N is the number of nodes in the linked lists.
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* tempA = headA;
        ListNode* tempB = headB;
        while(tempA!=tempB)
        {
            tempA=tempA==NULL ? headB : tempA->next;
            tempB=tempB==NULL ? headA : tempB->next;
        }
        return tempA;
    }
};


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 Time Complexity = O(N)
 Space Complexity = O(1)
 where N is the number of nodes in the linked lists.
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* temp;
        temp = headA;
        int lenA=0,lenB=0;
        while(temp!=NULL)
        {
            temp=temp->next;
            lenA++;
        }
        temp = headB;
        while(temp!=NULL)
        {
            temp=temp->next;
            lenB++;
        }
        while(lenA>lenB)
        {
            headA=headA->next;
            lenA--;
        }
        while(lenA<lenB)
        {
            headB=headB->next;
            lenB--;
        }
        while(headA!=headB)
        {
            headA=headA->next;
            headB=headB->next;
        }
        return headA;
    }
};

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
  Time Complexity = O(N)
 Space Complexity = O(1)
 where N is the number of nodes in the linked lists.
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* tempA = headA;
        ListNode* tempB = headB;
        while(tempA!=tempB)
        {
            if(tempA==NULL)
                tempA=headB;
            else
                tempA=tempA->next;
            
            if(tempB==NULL)
                tempB=headA;
            else
                tempB=tempB->next;
        }
        return tempA;
    }
};
