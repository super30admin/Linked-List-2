/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
 // create a reverse list
 // 1,2,3,4,5
 // 5,4,3,2,1

 // 1,5,2,4,3

 // we can do is we can find the middle of the list
 // 3
 // we can reverse the right part of the list
 // 5,4,3
 // 1,2
 
 //1->5->2->4->
class Solution {
public:
    void reorderList(ListNode* head) {
        // first we need to find the middle of the list
        ListNode *first = head;
        ListNode *second = head;

        while(second && second->next)
        {
            first = first ->next;
            second = second->next->next;
        }

        // now reverse the other part of the list
        ListNode *prev = NULL;
        ListNode *curr = first;
        ListNode *temp;

        while(curr!=NULL)
        {
            temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }


        //now we intialize two list with heads
        //original
        ListNode *org = head;
        ListNode *rev = prev;

        while(rev->next)
        {
            temp = org->next;
            org->next = rev;
            org = temp;

            temp = rev->next;
            rev->next = org;
            rev = temp;
        }

    }
};
//Time complexity O(N)
//space complexity O(1)