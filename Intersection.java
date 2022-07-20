/**Time Complexity :
    O(n)
// Space Complexity :
    O(1)
// Did this code successfully run on Leetcode :
     Accepted
// Any problem you faced while coding this :   
    NO
// Your code here along with comments explaining your approach**/

public class Intersection{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr;
        int lenA=0,lenB=0;
        curr=headA;
        while(curr!=null){
            lenA++;
            curr=curr.next;
        }
        curr=headB;
        while(curr!=null){
            lenB++;
            curr=curr.next;
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