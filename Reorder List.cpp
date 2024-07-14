// time: O(n)
// space: O(1)

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
        if(head == NULL || head -> next == NULL) {
            return;
        }
        // find middle element and split the list
        ListNode *slow = head;
        ListNode *fast = head;
        while(fast -> next != NULL && fast -> next -> next != NULL) {
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        fast = slow -> next;
        slow -> next = NULL;
        slow = head;
        // list1 = slow
        // list2 = fast
        
        // reverse list 2
        ListNode *pre = NULL;
        ListNode *post = fast -> next;
        while(fast != NULL && fast -> next != NULL) {
            fast -> next = pre;
            pre = fast;
            fast = post;
            post = post -> next;
        }
        fast -> next = pre;

        //merge 2 lists
        post = slow -> next;
        while(post != NULL) {
            slow -> next = fast;
            fast = fast -> next;
            slow -> next -> next = post;
            slow = post;
            post = post -> next;
        }
        slow -> next = fast;
        
    }
};