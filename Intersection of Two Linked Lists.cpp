// time: O(m+n)
// space: O(1)

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
        ListNode *ptr = headA;
        int count1 = 1;
        while(ptr != NULL) {
            ptr = ptr -> next;
            count1++;
        }
        ptr = headB;
        int count2 = 1;
        while(ptr != NULL) {
            ptr = ptr -> next;
            count2++;
        }
        ListNode *ptr2;
        ptr2 = headB;
        ptr = headA;
        if(count1 > count2) {
            
            while(count1 - count2 != 0) {
                ptr = ptr -> next;
                count1--;
            }
        }
        else {
            while(count2 - count1 != 0) {
                ptr2 = ptr2 -> next;
                count2--;
            }
        }
        while(ptr != NULL && ptr != ptr2) {
            ptr = ptr -> next;
            ptr2 = ptr2 -> next;
        }
        return ptr;
    }
};