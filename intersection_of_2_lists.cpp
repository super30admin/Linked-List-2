// Time Complexity : O(m+n) 
// m-> length of A, n->length of B
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Calculate the length of list A and list B. Adjust the longer list to have same #of nodes 
// as the smaller list. Then check the intersection point of both the lists.

//Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int lenA = 0;
        int lenB = 0;

        ListNode* nodeA = headA;
        ListNode* nodeB = headB;

        // Get length of A
        while(nodeA != nullptr)
        {
            lenA++;
            nodeA= nodeA->next;
        }
        
        // Get length of B
        while(nodeB != nullptr)
        {
            lenB++;
            nodeB= nodeB->next;
        }

        // Update the head to match the length of A and B
        while(lenA > lenB)
        {
            headA = headA->next;
            lenA--;
        }

        // Update the head to match the length of A and B
        while(lenB > lenA)
        {
            headB = headB->next;
            lenB--;
        }

        // finding the intersection point
        while(headA != nullptr || headB != nullptr)
        {
            if(headA == headB)
            {
                return headA;
            }
            headA = headA->next;
            headB = headB->next;
        }
        return nullptr;
    }
};