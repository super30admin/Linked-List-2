public class Problem4 {
    // Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO

    //approach is make the ptr a and b at same position mean the length of ll should be same
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lenA = 0;//find length of a
        ListNode ptrA = headA;
        while(ptrA != null){
            lenA++;
            ptrA = ptrA.next;
        }

        int lenB = 0;//find the length of b
        ListNode ptrB = headB;
        while(ptrB != null){
            lenB++;
            ptrB = ptrB.next;
        }
        ptrA = headA;
        ptrB = headB;

        //if len A is greater then move the ptr a until the length is same
        while(lenA > lenB){
            lenA--;
            ptrA = ptrA.next;
        }

        //if len B is greater then move the ptr b until the length is same
        while(lenB > lenA){
            lenB--;
            ptrB = ptrB.next;
        }

        while(ptrA!=ptrB){
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        return ptrA;
    }

}
