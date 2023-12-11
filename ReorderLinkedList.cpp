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
class Solution {
public:
    void reorderList(ListNode* head) {
        //find the middle (stop a node before middle)
        ListNode* slow = head;
        ListNode* fast = head;

        while(fast->next!= NULL && fast->next->next!= NULL )
        {
            slow = slow->next;
            fast = fast->next->next;
        }

        //reverse the list from middle
        fast = reverse(slow->next);
        //break the connection with middle half
        slow->next = NULL;      
        slow=head; 

        //combine two lists for the output
        while(fast!=NULL)
        {
            ListNode* temp = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = temp;
            slow = temp;
        }


    }

    private:

    ListNode * reverse(ListNode* head)
    {
        ListNode *curr = head;
        ListNode* prev = NULL;

        while(curr!= NULL)
        {
            ListNode *temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
};