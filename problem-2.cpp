// 143. Reorder List
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
reorders a singly linked list by first finding its midpoint using the slow and fast pointer technique. 
Then, splits the list into two halves and reverses the second half. After that, merges the first 
and reversed second halves by iteratively swapping pointers to alternate nodes between the two halves, 
effectively reordering the list in-place. Finally, returns the modified list.


*/

class Solution {
public:
    void reorderList(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast!=NULL && fast->next != NULL)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
        fast = slow->next;
        slow->next = NULL;
        slow = head;
        // reversing the second half
        fast = reverseList(fast);
        // merging
        mergeList(fast, slow);
        return;
    }
    void mergeList(ListNode* fast,ListNode* slow)
    {
        ListNode* prev = NULL;
        while(fast!=NULL)
        {
            prev = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = prev;
            slow = prev;
        }
        return;
    }
    ListNode* reverseList(ListNode* fast)
    {
        if(fast == NULL || fast->next==NULL)
            return fast;
        ListNode *p = NULL,*c = fast,*n = fast->next;
        while(n!=NULL)
        {
            c->next=p;
            p=c;
            c=n;
            n=n->next;
        }
        c->next=p;
        return c;
    }
    
};