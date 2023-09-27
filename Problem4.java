
//T.C  : O(m+n)
//S.C : O(1)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
public class Problem4 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lenA =0;
        ListNode curr = headA;
        while(curr != null){
            lenA++;
            curr = curr.next;
        }
        int lenB=0;
        curr = headB;
        while(curr != null){
            lenB++;
            curr = curr.next;
        }

        while(lenA > lenB ){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB= headB.next;
            lenB--;
        }

        while(headA != headB){
            headA= headA.next;
            headB = headB.next;
        }

        return headA;

    }
}
