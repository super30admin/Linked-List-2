// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Maintain a map to save previous node of each node and calculate index of middle node
// 2. Initialize left pointer to head and right to last node and increment till count = middle index
// 3. Set next of left to right, set right to original next of left, advance left and decrement right using map

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
        if(!head || !head->next)
            return;
        map<ListNode*, ListNode*> mapper;
        ListNode* prev = nullptr; 
        ListNode* curr = head;
        int len=0;
        while(curr !=nullptr){
            mapper[curr] = prev;
            prev=curr;
            curr=curr->next;
            len++;
        }
        // cout<<len<<endl;
        int mid = len/2;
        // cout<<mid;
        ListNode* left = head;
        ListNode* right= prev;
        ListNode* temp = left->next;
        int count=0;
        while(count<mid){
            count++;
            cout<<"left: "<<left->val<<" temp: "<<temp->val<<" right: "<<right->val<<endl;
            left->next = right;
            right->next = temp;
            left = temp; 
            temp=left->next;
            right = mapper[right];
        }
        left->next = nullptr;
    }
};