// Time Complexity : O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach

public class IntersectionOfTwoLinkedLists {
    /**
     * Definition for singly-linked list.
     * */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;

            //create a and b pointers
            ListNode a = headA, b = headB;

            //loops twice and during the second loop, they will intersect if there is an intersection else hit reach null
            while(a != b){
                //set a pointer to headb when we've reached the end of a else keep traversing
                if(a == null){
                    a = headB;
                } else {
                    a = a.next;
                }

                //set b pointer to heada when we've reached the end of b
                if(b == null){
                    b = headA;
                } else {
                    b = b.next;
                }
            }
            return a; //either a or b pointer can be returned as they are at the same point or null
        }
    }
}
