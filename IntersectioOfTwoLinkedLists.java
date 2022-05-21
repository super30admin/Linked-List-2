// Time Complexity : O(3N) = O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class IntersectioOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;

        ListNode currA = headA;
        ListNode currB = headB;
        int lenA = 0, lenB=0;

        while(currA !=null){
            lenA+=1;
            currA = currA.next;
        }

        while(currB !=null){
            lenB+=1;
            currB = currB.next;
        }

        //headstart the longer list
        currA = headA;
        currB = headB;
        int diff = Math.abs(lenA-lenB);
        if(lenA > lenB){
            while(diff != 0){
                currA = currA.next;
                diff-=1;
            }
        } else {
            while(diff != 0){
                currB = currB.next;
                diff-=1;
            }
        }

        //Increment both head at same speed until node match
        while(currA!=null) {
            if(currA == currB)
                return currA;
            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }
}