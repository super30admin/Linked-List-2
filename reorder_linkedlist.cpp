//TC: O(n)
//SC: O(1)
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
    ListNode *rev(ListNode *head)
    {
        ListNode *prev = NULL;
        ListNode *current = head;
        ListNode *temp;
        while (current != NULL)
        {
            temp = current->next;
            current->next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    void reorderList(ListNode *head)
    {
        ListNode *head2;
        ListNode *head1;
        ListNode *slow;
        ListNode *ptr = NULL;
        ListNode *temp1;
        ListNode *temp2;
        ListNode *fast;
        slow = head;
        fast = head;
        while (fast != NULL && fast->next != NULL)
        {
            slow = slow->next;
            fast = fast->next->next;
        }

        head2 = rev(slow);
        head1 = head;
        temp1 = head1;
        temp2 = head2;

        while (head2->next != NULL)
        {
            temp1 = temp1->next;
            temp2 = temp2->next;

            head1->next = head2;
            head2->next = temp1;

            head1 = temp1;
            head2 = temp2;
        }
    
    }
};