/*
Time Complexity:
O(n + m) as we are iterating both the lists 
*/

/*
Space Complexity:
O(1) as we are not creating any extra space for the claculations
*/

/*
Approach:
Two pointer approach is used as brute force was giving the time complexity of O(n*m) and hash map was using extra space.
We are trying to start traversing the lists at the same distance from the point of intersection so that where the two pointers
traversing the lists will meet giving us the point of intersection. To get this we find the length of the two lists and take the
differenc of the two lengths as this difference is the distance which we have to cover in one of the lists so that starting
point in both the lists is same.

To achieve that we try decrement the length of each list until it is less than the other one which is a kind of hack to reach
the starting ppoint in the longer list as we dont know hwich one is longer. After updating the starting point we just have to look where
the two pointers will cross each other*/


//The code ran perfectly on leetcode



class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int lenA = 0, lenB = 0;
        ListNode* itrA = headA;
        ListNode* itrB = headB;
        while(itrA != NULL){
            itrA = itrA->next;
            lenA++;
        }
        
        while(itrB != NULL){
            itrB = itrB->next;
            lenB++;
        }
        int diff = abs(lenA - lenB);
        
        while(lenA>lenB){
                headA = headA->next;
                lenA--;
        } 
        while(lenA <lenB) {
                headB = headB->next;
                lenB--;
        }
        while(headA !=headB){
            headA = headA->next;
            headB = headB->next;
        }
        return headA;
        
    }
};