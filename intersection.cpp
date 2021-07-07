// Time Complexity : O(m+n);  m, n are numbers of nodes in each list respectively 
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Maintain set of nodes and add each node of first list 
// 2. Traverse through second list and see if any node is found in set already
// 3. If found return that node else return nullptr

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        set<ListNode*> mapper;
        ListNode* itr = headA;
        while(itr != nullptr){
            mapper.insert(itr);
            itr=itr->next;
        }
        itr = headB;
        while(itr!=nullptr){
            if(mapper.find(itr) != mapper.end())
                return itr;
            itr=itr->next;
        }
        return itr;
    }
};