/* Time complexity: O(n)
space complexity: O(1)

*/
public class Solution{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode curr = headA;
        int lenA = 0; int lenB = 0;
        while(curr != null){
            curr = curr.next;
            lenA++;

        }
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lenB++;

        }

        while(lenA > lenB){
            headA = headA.next;
            lenA --;
        }
         while(lenB > lenA){
            headB = headB.next;
            lenB --;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}