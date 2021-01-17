// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


public class ListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        ListNode currA = headA;
        ListNode currB = headB;

        while(lenA > lenB){
            currA = currA.next;
            lenA--;
        }

        while(lenB > lenA){
            currB = currB.next;
            lenB--;
        }

        //lenA == lenB
        while(currA!=currB){
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
    }

    public int len(ListNode head){
        int count = 0;
        while(head!=null){
            head = head.next;
            count++;
        }
        return count;
    }
}