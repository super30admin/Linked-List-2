//time complexity:O(n)
//space complexity:O(1)
//executed on leetcode: yes
//approach:using hash set
//any issues faced? no

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
        set<ListNode*>set;
        ListNode* cur1=headA;
        while(cur1!=NULL)
        {
            set.insert(cur1);
            cur1=cur1->next;
        }
        ListNode* cur2=headB;
        while(cur2!=NULL)
        {
            if(set.find(cur2)!=set.end())
                return cur2;
            cur2=cur2->next;
        }
        return NULL;
    }
};