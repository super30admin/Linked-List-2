// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Traverse both the lists and keep a count. 
Maintain a gap of the difference between the counts and traverse one list accordingly. 
Move at speed 1x after that until you reach intersection. 
 * 
 */

public class Problem4 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if(headA == null || headB == null)
            return null; 
        ListNode ptrA = headA; 
        ListNode ptrB = headB; 
        int countA = 1; 
        int countB = 1; 
        while(ptrA.next != null){
            ptrA = ptrA.next; 
            countA++;
        }
        while(ptrB.next != null){
            ptrB = ptrB.next; 
            countB++;
        }
        ptrA = headA; 
        ptrB = headB;
        int max = Math.max(countA, countB);
        int n = Math.abs(countB- countA);
        if( max == countA){
            while(n > 0 && ptrA.next != null){
                ptrA = ptrA.next;
                n--;
            }
        }
        if(max == countB){
            while(n > 0 && ptrB.next != null){
                ptrB = ptrB.next;
                n--;
            }
        }
        while(ptrA != ptrB && ptrA.next!=null && ptrB.next!=null){
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        if(ptrA == ptrB){
            return ptrA;
        }
        else 
             return null; 
    }
}