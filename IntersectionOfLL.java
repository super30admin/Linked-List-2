// Time Complexity : O(M+N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.
// Your code here along with comments explaining your approach
/*
Calculate the length of the two LL, move the LL pointer of 2 LL to same start. then iterate until intersection
* */
public class IntersectionOfLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;

        ListNode currA=headA, currB=headB;

        int alen=0, blen=0;
        while(currA!=null){
            alen++;
            currA=currA.next;
        }


        while(currB!=null){
            blen++;
            currB=currB.next;
        }


        while(alen>blen){
            alen--;
            headA=headA.next;
        }

        while(blen>alen){
            blen--;
            headB=headB.next;
        }

        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }

        return headA;
    }
}
