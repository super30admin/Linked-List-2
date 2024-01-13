// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:i used two pointer approach.

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode temp1=headA;
        ListNode temp2=headB;

        while(temp1!=temp2){

            temp1= temp1.next;
            temp2= temp2.next;
            if(temp1==temp2) return temp1;

            if(temp1==null){
                temp1=headB;
            }
            if(temp2==null){
                temp2=headA;
            } 
        }
        return temp1;
    }
}
