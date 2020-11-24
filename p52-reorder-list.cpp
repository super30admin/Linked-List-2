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

// Time complexity is O(n) - n = #elements in linked list
// Space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
public:
    
    ListNode* reverse(ListNode* head) {
        ListNode* prev = nullptr;
        ListNode* curr = head;
        ListNode* fast = curr->next;
        while(fast != nullptr) {
            curr->next = prev;
            prev = curr;
            curr = fast;
            fast = fast->next;
        }
        curr->next = prev;
        return curr;
    }
    void reorderList(ListNode* head) {
        //edge
        if(head == nullptr || head->next == nullptr) return;
        
        //middle
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast->next != nullptr && fast->next->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        // slow is at middle
        fast = reverse(slow->next);
        slow->next = nullptr;
        slow = head;
        ListNode* curr;
        while(fast != nullptr) {
            curr = slow->next;
            slow->next = fast;
            fast = fast->next;
            slow->next->next = curr;
            slow = curr;
        }
        
        
    }
};

// Using a hashmap
// Time complexity is O(n) - n = #elements in linked list
// Space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    void reorderList(ListNode* head) {
        unordered_map<int, int> map;
        ListNode* node = head;
        int len = 0;
        int count = 0;
        while(node) {
            map[len] = node->val;
            node = node->next;
            len++;
        }
        for(int i = 0; i < 1+len/2; i++) {
            if(head){
                head->val = map[i];
                head = head->next;
            }
            if(head){
                head->val = map[len-1-i];
                head = head->next;
            }
            
            
        }
    }
};


// Time complexity is O(n) - n = #elements in linked list
// Space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


