// 160. Intersection of Two Linked Lists
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
iterating through headA and headB with two pointers ptr1 and ptr2. If either pointer reaches the end of its list, 
then wraps around to the beginning of the other list. They continue moving until they meet at the intersection 
point or reach the end of both lists, in which case ptr1 or ptr2 would be null, indicating no intersection.


*/

ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
    ListNode *ptr1 = headA;
            ListNode *ptr2 = headB;
            while(ptr1 != ptr2){
                if(ptr1 == NULL){
                    ptr1 = headB;
                }
                else{
                    ptr1 = ptr1 -> next;
                }
                if(ptr2 == NULL){
                    ptr2 = headA;
                }
                else{
                    ptr2 = ptr2 -> next;
                }
            }
        return ptr1;
}