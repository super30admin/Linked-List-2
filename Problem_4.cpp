// Author: Subhed Chavan
// Batch: December 24
// Problem Statement:
// Approach: Intersection of two linked list
// Time Complexity: O(m + n)
// Space Complexity: O(1)

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

class Solution
{
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB)
    {
        int lenA = 0, lenB = 0;

        // Pointers to traverse the two linked lists
        ListNode *ptrA = headA;
        ListNode *ptrB = headB;

        // Calculate the length of the first linked list
        while (ptrA)
        {
            lenA++;
            ptrA = ptrA->next;
        }

        // Calculate the length of the second linked list
        while (ptrB)
        {
            lenB++;
            ptrB = ptrB->next;
        }

        // Reset the pointers to the start of the respective lists
        ptrA = headA;
        ptrB = headB;

        // Align the pointers to the same starting point relative to the intersection
        if (lenA > lenB)
        {
            // If the first list is longer, move its pointer forward by the difference in lengths
            int t = lenA - lenB;
            while (t > 0)
            {
                ptrA = ptrA->next;
                t--;
            }
        }
        else
        {
            // If the second list is longer, move its pointer forward by the difference in lengths
            int t = lenB - lenA;
            while (t > 0)
            {
                ptrB = ptrB->next;
                t--;
            }
        }

        // Traverse both lists together to find the intersection point
        while (ptrA)
        {
            if (ptrA == ptrB) // Intersection found
            {
                return ptrA;
            }
            ptrA = ptrA->next;
            ptrB = ptrB->next;
        }

        // No intersection found
        return nullptr;
    }
};
