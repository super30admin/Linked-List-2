// -- TC = O(n)
//-- SC = O(1)
//First we will find legnth of both  LL, then will reduce the length of that list 
// which is bigger and then inceement both till we find match.
// Did this code successfully run on Leetcode :yes
public class Intersection2LL {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            int lenA = 0;
            ListNode curr = headA;
            while(curr != null){
                curr = curr.next;
                lenA++;
            }

            int lenB = 0;
            curr = headB;
            while(curr != null){
                curr = curr.next;
                lenB++;
            }

            while(lenA > lenB){
                headA = headA.next;
                lenA--;
            }
            while(lenB > lenA){
                headB = headB.next;
                lenB--;
            }

            while(headA != headB){
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
}