// Time Complexity : O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


/*
 It uses two pointers, each starting at the head of one list, and traverses both lists switching
 to the other list’s head upon reaching the end. This ensures both pointers travel equal distances
 by the time they either meet at the intersection or reach the end. If the pointers meet,
 that node is returned as the intersection; otherwise, null is returned.
 The solution runs in O(m + n) time and uses O(1) space, where m and n are the lengths of the two lists.
* */


public class IntersectionOf2LinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //return Solution1(headA,headB);
        //return Solution2(headA,headB);
        ListNode currA=headA;
        ListNode currB=headB;

        while(currA!=currB)
        {
            currA=currA.next;
            currB=currB.next;

            if(currA==null && currB==null)
                return null;
            if(currA==null)
                currA=headB;
            if(currB==null)
                currB=headA;

        }
        return currA;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
