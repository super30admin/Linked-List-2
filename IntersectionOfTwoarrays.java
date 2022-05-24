// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null && headB==null){
            return null;
        }
        //we take two pointers
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){//if pointers still not same
            if(a==null){//if a pointer is null, point it to b
                a = headB;
            }else{
                a = a.next;//or next
            }
            if(b==null){//same as above
                b = headA;
            }else{
                b = b.next;
            }
        }
        return a;
    }
}