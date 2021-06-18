// Time Complexity : O(m+n)
// Space Complexity :  O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        
        ListNode* currA = headA;
        ListNode* currB = headB;
        
        set<ListNode*> node_set;
        
        // Add all List A pointers to Hash Set
        while(currA)
        {
            // New Node condition
            if(node_set.find(currA) == node_set.end())
                node_set.insert(currA);
            else
            {
                cout << "Bingo" << endl;
                return currA;
            }    
            currA = currA->next;
        }
        
        // Return the First matching Pointer with B
        while(currB)
        {
            if(node_set.find(currB) != node_set.end())
                return currB;   
            
            currB = currB->next;
        }      
        return NULL;
    }
};