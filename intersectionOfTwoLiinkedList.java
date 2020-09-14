    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/intersection-of-two-linked-lists/
    Time Complexity for operators : o(n+m) ... n is length of one list and m is length of second list. 
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach -
                              
                #
                    A. Calculate the length of A and B list.
                    B. from that we will get to knoe  which length is higher. Once we know the list which is higher 
                       we will traverse thru that list till the difference of A and B list gets cleared
                    C. Now, List A and B are at the same length from end. Now, traverse from both the list
                       till we get the equal point.
                    D. at the end, return any of the list.

       */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

   class reorderList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null)
            return null;
        
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        
        int lengthA = 0;
        int lengthB = 0;
        
        while(dummyA!=null){
            lengthA += 1;
            dummyA = dummyA.next;
        }
        
        while(dummyB!=null){
            lengthB += 1;
            dummyB = dummyB.next;
        }
        
        dummyA = headA;
        dummyB = headB;

        if(lengthA < lengthB){
            while(lengthA!=lengthB){
                dummyB = dummyB.next;
                lengthB -= 1;
            }
        }
        
                
        if(lengthA > lengthB){
            while(lengthA!=lengthB){
                dummyA = dummyA.next;
                lengthA -= 1;
            }
        }
        
        while(dummyA!=dummyB){
            dummyA = dummyA.next;
            dummyB = dummyB.next;
        }
        return dummyA;
    }
}