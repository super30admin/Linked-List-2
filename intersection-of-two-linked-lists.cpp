//Time complexity - O(n) - n is the total num of nodes
//Space complexity O(1)

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode *h1 = headA, *h2 = headB;
        while(h1!=h2){
            if(h1) h1 = h1->next;
            else h1 = headB;
            if(h2) h2 = h2->next;
            else h2 = headA;
        }
        return h1;
    }
};