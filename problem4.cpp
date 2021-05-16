/*
Time complexity - O(M + N), M and N are the lengths of the two LL
Space complexity - O(1)
*/
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
        int n1 = 0, n2 = 0;
        ListNode *node1 = headA, *node2 = headB;
        while(node1){
            ++n1; node1 = node1->next;
        }
        while(node2){
            ++n2; node2 = node2->next;
        }
        node1 = headA; node2 = headB;
        if (n1 > n2){
            while (n1-- > n2){
                node1 = node1->next;
            }
        }
        else{
            while(n2-- > n1){
                node2 = node2->next;
            }
        }
        while (node1){
            if (node1 == node2) return node1;
            node1 = node1->next;
            node2 = node2->next;
        }
        return NULL;
    }
};