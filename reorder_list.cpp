// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Idea here is to split the list into half and reverse the second half and then merge the lists
// such that we get one element from sub list 1 and other element from sub list 2.


//Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    void reorderList(ListNode* head) {
        if(head == nullptr || head->next == nullptr || head->next->next ==nullptr)
        {
            return;
        }

        ListNode* slow = head;
        ListNode* fast = head;

        // find center and split into two lists
        while(fast->next != nullptr && fast->next->next != nullptr)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
        // Reverse second list
        fast = reverse(slow->next);
        slow->next = nullptr;
        slow = head;

        // Merge the second list
        while(fast != nullptr)
        {
            ListNode* temp = slow->next;
            slow->next = fast; 
            fast = fast->next;
            slow->next->next = temp;
            slow = temp;
        }
    }

    ListNode* reverse(ListNode* node)
    {
        ListNode* curr = node;
        ListNode* prev = nullptr;

        while(curr != nullptr)
        {
            ListNode* temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
};