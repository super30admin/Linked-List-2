//Time Complexity: O(m+n)
//Space Complexity: O(1)
//Did this code successfully run on Leetcode : Yes

//Approach: 
//1. Find the length of both the linked lists.
//2. Move the pointer of the longer linked list by the difference of the lengths of the two linked lists.
//3. Now, move both the pointers simultaneously until they meet at the intersection point.
//4. If they do not meet, return nullptr.

class Solution {
    public:
        ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
            int count1 = 0, count2 = 0; 
            ListNode* one = headA;
            ListNode* two = headB;
            while(one != nullptr){
                count1++;
                one = one -> next;
            }
            while(two != nullptr){
                count2++;
                two = two -> next;
            }
            one = headA;
            two = headB;
            int offset = abs(count1 - count2);
            if(count1 > count2){
                while(offset > 0){
                    one = one -> next;
                    offset--;
                }
            }
            else if(count2 > count1){
                while(offset > 0){
                    two = two -> next;
                    offset--;
                }
            }
            while(one != nullptr && two != nullptr){
                if(one == two){return one;}
                one = one -> next;
                two = two -> next;
            }
            return nullptr;
        }
    };