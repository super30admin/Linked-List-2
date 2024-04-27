//Time O(n)
 //Space O(1)
 //Leetcode yes
 //issue seen: none
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int lenA = 0, lenB = 0;
        ListNode* node = headA;
        while(node){
            node = node->next;
            lenA++;
        }
        node = headB;
        while(node){
            node = node->next;
            lenB++;
        }
        int diff = 0;
        if(lenA > lenB){
            diff = lenA - lenB;
            while(diff && headA){
                headA = headA->next;
                diff--;
            }
        } else {
            diff = lenB -lenA;
            while(diff && headB){
                headB = headB->next;
                diff--;
            }
        }
        while(headA && headB && (headA != headB)){
            headA = headA->next;
            headB = headB->next;
        }
        return headA;
    }
};
