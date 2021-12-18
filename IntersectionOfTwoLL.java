// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
public class IntersectionOfTwoLL{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode currA=headA;
        int lenA=0;
        while(currA!=null){
            currA=currA.next;
            lenA++;
        }
        ListNode currB=headB;
        int lenB=0;
        while(currB!=null){
            currB=currB.next;
            lenB++;
        }
       while(lenA>lenB){
           headA=headA.next;
           lenA--;
       }
         while(lenB>lenA){
           headB=headB.next;
           lenB--;
       }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}