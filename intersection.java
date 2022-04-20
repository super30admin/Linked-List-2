 //T.C: O(N+M) where N and M are length of both the list. Asymptotically T.C= O (N)
// S.C: O(1)
/* public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode curr=headA;
        int lengthA=0;
        while(curr!=null && curr.next!=null){
            curr=curr.next;
            lengthA++;
        }
        
        curr=headB;
        int lengthB=0;
        while(curr!=null && curr.next!=null){
            curr=curr.next;
            lengthB++;
        }
        
        while(lengthA<lengthB){
            lengthB--;
            headB=headB.next;
        }
        while(lengthB<lengthA){
            lengthA--;
            headA=headA.next;
        }
        
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
