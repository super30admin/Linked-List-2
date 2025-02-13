// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 143: Reorder List
// Approach: Splitting, Merging and Reversing Linked List
// TC: O(n)
// SC: O(1)

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

class Solution
{
public:
    void reorderList(ListNode *head)
    {

        // Base Case
        if (!head || !head->next)
        {
            return;
        }

        // Split the list into two parts
        ListNode *slow = head;
        ListNode *fast = head;
        while (fast->next != nullptr && fast->next->next != nullptr)
        {
            slow = slow->next;
            fast = fast->next->next;
        }

        // Reverse the second half
        fast = reverseList(slow->next);
        slow->next = nullptr;

        // Merge the two lists
        slow = head;
        while (fast != nullptr)
        {
            ListNode *temp = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = temp;
            slow = temp;
        }
    }

    // Reversing the linked list
    ListNode *reverseList(ListNode *head)
    {
        if (!head || !head->next)
        {
            return head;
        }
        ListNode *prev = nullptr;
        ListNode *curr = head;
        ListNode *fast = curr->next;
        while (fast != nullptr)
        {
            curr->next = prev;
            prev = curr;
            curr = fast;
            fast = fast->next;
        }
        curr->next = prev;
        return curr;
    }
};
