// Time Complexity: O(m+n) where m and n are the lengths of the two linked lists heads
// Space Complexity: O(1)
// Were you able to solve the problem on Leetcode?: Yes
// Did you face any challenges while solving the problem? No
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

        // If either of the lists is empty, there cannot be an intersection
        if (headA == nullptr || headB == nullptr){
            return nullptr;
        }

        ListNode* currA = headA;
        ListNode* currB = headB;

        // Traverse both lists simultaneously
        // If one pointer reaches the end of its list, redirect it to the head of the other list
        // This way, both pointers will traverse the same number of nodes when they meet
        // If they meet, it means there is an intersection point
        while(currA != currB){

            currA = currA->next;
            currB = currB->next;
            
            // If both pointers reach the end of their respective lists, return nullptr since there is no intersection
            if (currA == nullptr && currB == nullptr) return nullptr;
            
            
            if(currA == nullptr) {
                currA = headB;
            }

            if(currB == nullptr) {
                currB = headA;
            }

        }

        // If the pointers meet, return the intersection node
        return currA;
    }
};